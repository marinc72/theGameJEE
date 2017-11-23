/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;



/**
 *
 * @author marin
 */
@Stateless
public class UserDAO {
    
    @PersistenceContext(unitName = "GamePU")
    EntityManager em;
    private User usr=null;
    private int usrID;
    private User usrPerso;
    
    public List<User> findAll(){
        return em.createNamedQuery("User.findAll").getResultList();
    }
    

    
    public User findIdbyLogin(String login){
        this.usrPerso= (User)em.createNamedQuery("User.findByLogin")
                .setParameter("login", login)
                .getSingleResult();
        return this.usrPerso;
    }
    
    public int getID(){
        return usr.getId();
    }
    
    public boolean tryCreateUser(String username, String password){
        try{
            usr=(User)em.createNamedQuery("User.findByLogin")
                .setParameter("login", username)
                .getSingleResult();    
        }
        catch(NoResultException e){
            User newUsr = new User(0,username,password);
            em.persist(newUsr);
            return true;
        }
        return false;
    }
    
    public boolean tryLogin(String username, String password){
        try{
            usr=(User)em.createNamedQuery("User.findLogins")
                    .setParameter("password",password)
                    .setParameter("login",username)
                    .getSingleResult();
        }
        catch(NoResultException e){
            return false;
        }
        return true;
    }
    
}
