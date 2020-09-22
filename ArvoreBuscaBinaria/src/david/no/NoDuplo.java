/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.no;

/**
 *
 * @author david
 */
public class NoDuplo <T> extends No<T>{
    //usaria isso para ser uma composição e nao herança
    //private No<T> no; //feito isso para evitar herança
    private NoDuplo<T> anterior;
      
    public NoDuplo(T valor) {
        super(valor);
        this.anterior = null;
    }

    public NoDuplo<T> getAnterior() {
        return this.anterior;
    }

    public void setAnterior(NoDuplo<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public NoDuplo<T> getProximo() {
        return (NoDuplo<T>) super.getProximo(); 
    }
}
