/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.iteradores;

import david.no.NoDuplo;

/**
 *
 * @author david
 */
public class IteradorListaDuplamenteLigada<T> {
    private NoDuplo<T> posicaoAtual;
    
    public IteradorListaDuplamenteLigada(NoDuplo<T> inicio){
        NoDuplo<T> dummy = new NoDuplo<>(null);
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
