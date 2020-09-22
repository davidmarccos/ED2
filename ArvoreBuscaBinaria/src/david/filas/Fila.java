/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.filas;
import david.no.No;
import david.listas.ListaSimplesmenteLigada;
import david.excessoes.ItemNaoEncontradoException;
/**
 *
 * @author minci
 */
public class Fila {
    ListaSimplesmenteLigada elementos = new ListaSimplesmenteLigada();
    
    //uma fila sempre se adiciona no fim
    public void inserir(No umNo){
        this.elementos.adicionaFim(umNo);
    }
    
    //para remover de uma fila, não precisa de parametros pois sempre se remove do inicio
    public No remover() throws ItemNaoEncontradoException{
       return this.elementos.removerInicio();
    }
}
