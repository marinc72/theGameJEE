/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author marin
 */
@Named(value="controlerPersonnage")
@ManagedBean
@SessionScoped
public class PersonnageCtrl implements Serializable{
    @EJB
    
    private PersonnageDAO dao;
    private String usrName;
    private Personnage newPersonnage;

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }
    
    public String createPerso(int idNewPerso){
        FacesContext context = FacesContext.getCurrentInstance();
        dao.createPerso(idNewPerso,this.usrName);
        context.addMessage(null, new FacesMessage("Well done, here created"));
        return "homePage";
    }
    
    public int getPersoID(int idusr){
        return dao.getPerso(idusr);
    }
    
    public String getPersoNom(int idusr){
        return dao.getNom(idusr);
    }

    public int getPersoLevel(int idusr){
        return dao.getLevel(idusr);
    }    
    
    public int getPersoExp(int idusr){
        return dao.getExp(idusr);
    }    
    
    public String updatePerso(int idPerso, int exp){
        dao.updateHero(idPerso, exp);
        return "missions";
    }
}
