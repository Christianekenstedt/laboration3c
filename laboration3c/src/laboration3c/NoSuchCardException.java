/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboration3c;

/**
 *
 * @author Zetterman
 */
public class NoSuchCardException extends RuntimeException {
    
    public NoSuchCardException(String msg){
        super(msg);
    }
    
    public NoSuchCardException(){
        super();
    }
}
