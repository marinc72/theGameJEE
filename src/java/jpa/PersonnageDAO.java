/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import static com.sun.codemodel.JOp.mod;
import static com.sun.el.lang.ELArithmetic.mod;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import static sun.util.calendar.CalendarUtils.mod;

/**
 *
 * @author marin
 */
@Stateless
public class PersonnageDAO {
    
    @PersistenceContext(unitName = "GamePU")
    EntityManager em;
    Personnage persoRenvoi;
    Personnage persoUpdate;
    
    
    public void createPerso(int idUsr, String usrName){
        Personnage perso = new Personnage(0,idUsr,1,0,usrName);
        em.persist(perso);
    }
    
    public int getPerso(int idUsr){
        persoRenvoi = (Personnage)em.createNamedQuery("Personnage.findByIdUsr")
                .setParameter("idUsr", idUsr)
                .getSingleResult();
        return persoRenvoi.getId();
    }
    
    public String getNom(int idUsr){
        persoRenvoi = (Personnage)em.createNamedQuery("Personnage.findByIdUsr")
                .setParameter("idUsr", idUsr)
                .getSingleResult();
        return persoRenvoi.getNomPerso();
    }    
    
    public int getLevel(int idUsr){
        persoRenvoi = (Personnage)em.createNamedQuery("Personnage.findByIdUsr")
                .setParameter("idUsr", idUsr)
                .getSingleResult();
        return persoRenvoi.getLevel();
    } 
    
    public int getExp(int idUsr){
        persoRenvoi = (Personnage)em.createNamedQuery("Personnage.findByIdUsr")
                .setParameter("idUsr", idUsr)
                .getSingleResult();
        return persoRenvoi.getExperience();
    }     
    
    public void updateHero(int idPerso,int exp){
        persoUpdate = (Personnage)em.createNamedQuery("Personnage.findById")
                .setParameter("id", idPerso)
                .getSingleResult();
        persoUpdate.setExperience(persoUpdate.getExperience()+exp);
        int exp1 = persoUpdate.getExperience();
        int exp2 = persoUpdate.getExperience() % 100;
        persoUpdate.setLevel((exp1 - exp2)/ 100);
    }
}
