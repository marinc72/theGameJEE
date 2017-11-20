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

@Named(value="controlerUser")
@ManagedBean
@SessionScoped
public class UserCtrl implements Serializable{
    
    @EJB
    private UserDAO dao;
    private User usr;
    private String usrname;
    private String pwd;
    private boolean boolLogin;
    private int id=0;

    
    
    public int getActId(){
        return this.id;
    }
    
    public String testLogin(){
        boolLogin = dao.tryLogin(this.usrname, this.pwd);
        if(boolLogin){
            id=dao.getID();
            return "missions";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Authentification invalide",
                    "Merci de reessayer!!!"));
            return "homePage";
        }
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public UserCtrl(){
        this.usr=new User();
    }
    
    public User getUsr() {
        return usr;
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }
    
    public List<User> getUsers(){
        return this.dao.findAll();
    }
}
