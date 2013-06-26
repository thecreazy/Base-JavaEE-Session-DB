/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.User;
import java.util.List;
import javax.ejb.Local;
import myExceptions.NullQueryFindException;

/**
 *
 * @author luigi23
 */
@Local
public interface UserFacadeLocal {

    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);

    List<User> findAll();

    List<User> findRange(int[] range);

    User getForLogin (String email, String password)throws NullQueryFindException;
    
    int count();
    
}
