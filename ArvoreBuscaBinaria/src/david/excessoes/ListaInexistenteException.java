/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.excessoes;

/**
 *
 * @author david
 */
public class ListaInexistenteException extends Exception {
    public ListaInexistenteException() {
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
