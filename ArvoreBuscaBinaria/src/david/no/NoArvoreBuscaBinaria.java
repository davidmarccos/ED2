/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.no;

/**
 *
 * @author david
 * @param <T>
 */

//USAR O COMPARABLE
public class NoArvoreBuscaBinaria<T extends Comparable<T>> {
    private T valor;
    private NoArvoreBuscaBinaria<T> direita;
    private NoArvoreBuscaBinaria<T> esquerda;

    //criando os construtores
    /*public NoArvoreBuscaBinaria(T valor, NoArvoreBuscaBinaria<T> direita, NoArvoreBuscaBinaria<T> esquerda) {
        this.valor = valor;
        this.direita = direita;
        this.esquerda = esquerda;
    }*/

    public NoArvoreBuscaBinaria(T valor) {
        this.valor = valor;
        this.direita = null;
        this.esquerda = null;
    }

    public NoArvoreBuscaBinaria<T> getDireita() {
        return direita;
    }

    public NoArvoreBuscaBinaria<T> getEsquerda() {
        return esquerda;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public void setDireita(NoArvoreBuscaBinaria<T> direita) {
        this.direita = direita;
    }

    public void setEsquerda(NoArvoreBuscaBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }
    
    
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    public int compareTo(T valor){
        return this.valor.compareTo(valor);
    }
    
    
    
    
    
}


