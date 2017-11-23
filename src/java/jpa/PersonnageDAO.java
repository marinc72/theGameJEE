/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

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

/**
 *
 * @author marin
 */
@Stateless
public class PersonnageDAO {
    
    @PersistenceContext(unitName = "GamePU")
    EntityManager em;
    
    
    public void createPerso(int idUsr, String usrName){
        Personnage perso = new Personnage(0,idUsr,1,0,usrName);
        em.persist(perso);
    }
}
