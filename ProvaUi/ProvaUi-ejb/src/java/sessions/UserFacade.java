/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import myExceptions.NullQueryFindException;

/**
 *
 * @author luigi23
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {
    @PersistenceContext(unitName = "ProvaUi-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    
    public User getForLogin(String email, String password) throws NullQueryFindException{
        System.out.println("Login of "+email+"  "+password);
        List<User> result = getEntityManager().createNamedQuery("User.findByEmailAndPassword")
                    .setParameter("mail", email).setParameter("pwd", password).getResultList();
        if(result.size()==0){
            throw new NullQueryFindException("The User " + email +" whit password " +password +" NOT EXIST!");
        }
        return result.get(0);
    }
    
}
