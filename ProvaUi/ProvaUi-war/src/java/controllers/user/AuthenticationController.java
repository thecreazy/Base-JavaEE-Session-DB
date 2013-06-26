/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.user;

import entities.User;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import myExceptions.NullQueryFindException;
import sessions.UserFacadeLocal;
import utils.MySecurity;

/**
 *
 * @author luigi23
 */
@ManagedBean(name = "auth_contr")
public class AuthenticationController {

    /**
     * Creates a new instance of AuthenticationController
     */
    
    @EJB 
    UserFacadeLocal userFacade;
    
    private String email; 
    private String password;
    
    public AuthenticationController() {
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();  
        Map<String,Object> map = extContext.getSessionMap();
        if(map.containsKey("user"))
        try {
            extContext.redirect(extContext.getRequestContextPath() + "/pages/welcome_page.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = MySecurity.getMd5(password);
    }
    
    public String login(){
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        try {
            User current = userFacade.getForLogin(email, password);
            sessionMap.put("user", current);
            return "pages/welcome_page?faces-redirect=true";
        } catch (NullQueryFindException ex) {
            System.out.println(ex.getMessage());
            return "login?faces-redirect=true";
        }
        
    }
}
