/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.New;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import jdk.nashorn.internal.runtime.JSType;

/**
 *
 * @author marin
 */
@Stateless
public class MissionsDAO {
    
    @PersistenceContext(unitName = "GamePU")
    EntityManager em;
    List<Missions> miss = new ArrayList<Missions>();
    Missions missionId;
    
    
    public Date getMissionId(int idUsr){
        missionId = (Missions)(em.createNamedQuery("Missions.findByIdUser")
                .setParameter("idUser", idUsr)
                .getSingleResult());
        return missionId.getTemps();
    }
    
    public int getMissionExp(int idUsr){
        missionId = (Missions)em.createNamedQuery("Missions.findByIdUser")
                .setParameter("idUser", idUsr)
                .getSingleResult();  
        if(missionId.getType() == 1){
            return 30;
        }
        else if(missionId.getType() == 2){
            return 120;
        }
        else return 350;
    }
    
    public void deleteMiss(int idUsr){
        em.createNamedQuery("Missions.delete")
                .setParameter("idUser", idUsr);
    }
    
    
    @Temporal(TemporalType.TIMESTAMP)
    public boolean sendMission(int idUsr, int idMission){
        FacesContext context = FacesContext.getCurrentInstance();
        miss=(List<Missions>)em.createNamedQuery("Missions.findByIdUser")
                .setParameter("idUser", idUsr)
                .getResultList();
        if(miss.isEmpty()){
            switch (idMission) {
                case 1:
                    {
                        
                        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                        date.setTime(date.getTime()+((1 * 5) * 1000)); //30 * 60
                        Missions mission= new Missions(0,idUsr,date,idMission);
                        em.persist(mission);
                        
                        return true;
                    }
                case 2:
                    {
                        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                        date.setTime(date.getTime()+((90 * 60) * 1000));
                        Missions mission= new Missions(0,idUsr,date,idMission);
                        em.persist(mission);

                        return true;
                    }
                default:
                    {
                        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                        date.setTime(date.getTime()+((240 * 60) * 1000));
                        Missions mission= new Missions(0,idUsr,date,idMission);
                        em.persist(mission);

                        return true;
                    }
            }

        }
        else{
            return false;
        }
    }
    
}
