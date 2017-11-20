/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.List;
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
@Named(value="controlerMissions")
@ManagedBean
@SessionScoped
public class MissionsCtrl implements Serializable{
    @EJB
    private MissionsDAO dao;
    
    
    
    public String sendIntoMission(int idUsr, int idMission){
            dao.sendMission(idUsr, idMission);
            return "homePage";
            }
}    
   
