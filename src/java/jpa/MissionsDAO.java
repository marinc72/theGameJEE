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
    
    @Temporal(TemporalType.TIMESTAMP)
    public void sendMission(int idUsr, int idMission){
        FacesContext context = FacesContext.getCurrentInstance();
        miss=(List<Missions>)em.createNamedQuery("Missions.findByIdUser")
                .setParameter("idUser", idUsr)
                .getResultList();
        if(miss.isEmpty()){
            switch (idMission) {
                case 1:
                    {
                        
                        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                        date.setTime(date.getTime()+((30 * 60) * 1000));
                        Missions mission= new Missions(0,idUsr,date,idMission);
                        em.persist(mission);
                        context.addMessage(null, new FacesMessage("Successful sent into mission"));
                        break;
                    }
                case 2:
                    {
                        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                        date.setTime(date.getTime()+((90 * 60) * 1000));
                        Missions mission= new Missions(0,idUsr,date,idMission);
                        em.persist(mission);
                        context.addMessage(null, new FacesMessage("Successful sent into mission"));
                        break;
                    }
                default:
                    {
                        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                        date.setTime(date.getTime()+((240 * 60) * 1000));
                        Missions mission= new Missions(0,idUsr,date,idMission);
                        em.persist(mission);
                        context.addMessage(null, new FacesMessage("Successful sent into mission"));
                        break;
                    }
            }

        }
        else{
             context.addMessage(null, new FacesMessage("Wait your mission to finish to send your hero into a new one ..."));
        }
    }
    
}
