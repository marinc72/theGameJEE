/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
    
    public List<User> findAll(){
        return em.createNamedQuery("User.findAll").getResultList();
    }
    
    public int getID(){
        return usr.getId();
    }
    
    public boolean tryLogin(String username, String password){
        usr=(User)em.createNamedQuery("User.findLogins")
                .setParameter("password",password)
                .setParameter("login",username)
                .getSingleResult();
        if(usr == null)
            return false;
        else return true;
    }
    
}
