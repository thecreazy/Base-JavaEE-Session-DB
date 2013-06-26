/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myExceptions;

/**
 *
 * @author luigi23
 */
public class NullQueryFindException extends Exception{
    private String message;
    
    public NullQueryFindException (String mess){
        this.message=mess;
    }    
    
    public String toString (){
        return "MESSAGE="+this.message+"\nSTACK TRACE: "+super.getStackTrace();
    }
    
    public String getMessage (){
        return this.message;
    }
}
