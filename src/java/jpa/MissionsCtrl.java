/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    private int id;
    
    
    public String sendIntoMission(int idUsr, int idMission){
            dao.sendMission(idUsr, idMission);
            return "inMission";
            }
    
    public String displayDateF(Date dateF){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'à' HH'h'mm");
        String dateDisplaying = formatter.format(dateF);
        return dateDisplaying;
    }
    

        public Date getMissionId(int idUsr){
        return dao.getMissionId(idUsr);
    }
    
        public long getTime(Date d){
            return (long)d.getTime();
        }

}    
   
