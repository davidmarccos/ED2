/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.pilhas;

import david.excessoes.ItemNaoEncontradoException;
import david.listas.ListaSimplesmenteLigada;
import david.no.No;

/**
 *
 * @author david
 */
public class Pilha {
     ListaSimplesmenteLigada elementos = new ListaSimplesmenteLigada();
    
    //uma fila sempre se adiciona no inicio
    public void inserir(No umNo){
        this.elementos.adicionaInicio(umNo);
    }
    
    //para remover de uma pilha, não precisa de parametros pois sempre se remove do inicio
    public No remover() throws ItemNaoEncontradoException{
       return this.elementos.removerInicio();
    }
}
