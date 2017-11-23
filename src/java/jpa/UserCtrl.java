/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import static com.sun.faces.facelets.util.Path.context;
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
    private PersonnageDAO daoPerso;
    private PersonnageCtrl ctrlPerso;
    private User usr;
    private String usrname;
    private String pwd;
    private boolean boolLogin;
    private int id=0;
    private int actMissId;
    private String checkPwd;
    private boolean boolCreate;
    private int newPersoId;
    private Personnage newPerso;

    public String getCheckPwd() {
        return checkPwd;
    }

    public void setCheckPwd(String checkPwd) {
        this.checkPwd = checkPwd;
    }

    
    
    public int getActId(){
        return this.id;
    }
    
    public String createUser(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(!this.pwd.equals(this.checkPwd)){
            context.addMessage(null, new FacesMessage("Please type the same password twice"));
            return "inscription";
        }
        boolCreate = dao.tryCreateUser(this.usrname,this.checkPwd);
        if(boolCreate){
            context.addMessage(null, new FacesMessage("User created"));
            this.newPersoId = dao.findIdbyLogin(this.usrname).getId();
            this.id=newPersoId;
            return "creationPerso";
        }
        else{
            context.addMessage(null, new FacesMessage("Username already taken"));
            return "inscription";
        }
    }
    
    public String testLogin(){
        boolLogin = dao.tryLogin(this.usrname, this.pwd);
        FacesContext context = FacesContext.getCurrentInstance();
        if(boolLogin){
            id=dao.getID();
            context.addMessage(null, new FacesMessage("Successful connection"));
            return "missions";
        }
        else{
            context.addMessage(null, new FacesMessage("Failed login"));
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
