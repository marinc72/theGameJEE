/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author marin
 */
@Stateless
public class MissionsDAO {
    @PersistenceContext(unitName = "GamePU")
    EntityManager em;

    
    @Temporal(TemporalType.TIMESTAMP)
    public void sendMission(int idUsr, int idMission){
//        em.createNamedQuery("User.findLogins")
//            .setParameter("idUsr",idUsr)
//            .setParameter("tmps",idMission);
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'à' HH'h'mm");
//        String dateDisplaying = formatter.format(new Date());
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        Missions mission= new Missions(0,idUsr,date,idMission);

        em.persist(mission);
        
    }
    
}

