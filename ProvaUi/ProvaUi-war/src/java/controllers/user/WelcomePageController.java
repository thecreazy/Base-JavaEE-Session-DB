/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.user;

import entities.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSessionEvent;
import utils.MySecurity;

/**
 *
 * @author luigi23
 */
@ManagedBean(name = "wel_page_controller")
@RequestScoped
public class WelcomePageController {

    /**
     * Creates a new instance of WelcomePageController
     */
    private String currentFirstName;
    private String currentLastName;
    private User current;
    
    public String getCurrentFirstName() {
        return currentFirstName;
    }

    public String getCurrentLastName() {
        return currentLastName;
    }
    
    public WelcomePageController() {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        current = (User) sessionMap.get("user");
        currentFirstName=current.getFirstName();
        currentLastName=current.getLastName();
    }
    
    public String logout (){
        System.out.println("Sono in logout");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");
        return "/login?faces-redirect=true";
    }
    
    

}
