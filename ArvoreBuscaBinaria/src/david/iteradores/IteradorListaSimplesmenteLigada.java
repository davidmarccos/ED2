/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.iteradores;

import david.no.No;

/**
 *
 * @author david
 */
public class IteradorListaSimplesmenteLigada<T> {
    private No<T> posicaoAtual;
    
    public IteradorListaSimplesmenteLigada(No<T> inicio){
        No<T> dummy = new No<>(null);
        dummy.setProximo(inicio);
        this.posicaoAtual = dummy;
    }
    
    public boolean existeProximo(){
        return this.posicaoAtual.getProximo() != null;
    }
    
    public T getProximo(){
        posicaoAtual = posicaoAtual.getProximo();
        return posicaoAtual.getValor();
    }
}
