/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.listas;

import david.excessoes.ItemNaoEncontradoException;
import david.excessoes.PosicaoInvalidaException;
import david.iteradores.IteradorListaDuplamenteLigada;
import david.iteradores.IteradorListaSimplesmenteLigada;
import david.no.No;
import david.no.NoDuplo;

/**
 *
 * @author david
 */
public class ListaDuplamenteLigada <T>{
    private NoDuplo<T> inicio;
    private NoDuplo<T> fim;
    
    //inicializo a lista apontando para null;
    //não precisava fazer isso pois por padrão ja se inicializa null
    public ListaDuplamenteLigada() {
        inicio = null;
        fim = null;
    }

    //meu contrutor
    public ListaDuplamenteLigada(T elementos[]) {
         for (T a : elementos) {
            this.adicionaFim(a);
        }
    }

    public NoDuplo<T> getInicio() {
        return inicio;
    }
    
    //
    public void adicionaFim(T novo) {
        NoDuplo<T> no = new NoDuplo<>(novo);
        if (inicio == null){
            inicio = no;
        } else {
            no.setAnterior(fim);
            fim.setProximo(no);
        }
        fim = no;
    }
    
    public void adicionaInicio(T novo) {
        NoDuplo<T> no = new NoDuplo<>(novo);
        //seto o anterior do inicio antigo como sendo o novo nó
        inicio.setAnterior(no);
        no.setProximo(inicio);
        inicio = no;
        
        if (fim == null){
            fim = no;
        }
    }
    
    public void adicionaPos(T valor,int pos) throws PosicaoInvalidaException{
        if (pos==0){
            adicionaInicio(valor);
        } else {
            NoDuplo<T> novo = new NoDuplo<>(valor);
            int aux =0;
            NoDuplo<T> iterador = inicio;
            while(iterador != null){
                if(aux == pos-1){ //pos-1 é a posição real
                    //achei a posição então dou break
                    break;
                }
                iterador = iterador.getProximo();
            }
            // iterador aponta -> proximo, que aponta -> anterior
            novo.setProximo(iterador);
            novo.setAnterior(iterador.getAnterior());
            novo.getAnterior().setProximo(novo);
            novo.getProximo().setAnterior(novo);
        }
    }
    
    
    //RESPOSTA DA ATIVIDADE DE CRIAR OS OUTROS METODOS DE LISTA LIGADA
    //NA LISTA DUPLA
    //DAVID MARCOS DE ALBUQUERQUE COSTA
    
    /**
     * Esse método devolve o elemento da i-ésima posição.
     * 
     * @para i Posição do elemento a ser recuperado na lista
     * 
     * @return Elemento da posição i ou null caso a posição não exista na lista.
     * 
    */
    public NoDuplo<T> elementoEm(int i) throws ItemNaoEncontradoException{
        
        //crio o elementoDesejado do tipo No que vai receber o elemento da i-esima posicao
        NoDuplo<T> elementoDesejado = null;
        //crio uma variavel auxiliar que verifica se a posicao atual é a i-esima posicao
        int pos=0;
        
        //percorro a lista até chegar ao fim
        for(NoDuplo<T> umNo = inicio; umNo != null; pos++){
            if(pos == i){ //se a posição é a mesma que o i
                //pego o elemento da posição i desejada
                elementoDesejado = umNo;
                break;
            }else{
                //passo para o proximo no
                umNo = umNo.getProximo();
            }
        }
        
        //caso a i-esima posição não exista, lanço a excessão
        if(elementoDesejado == null){
            throw new ItemNaoEncontradoException();
        }
        else{
            //retorno o elemento da i-esima posicao desejada
            return elementoDesejado;
        }
    }
    
    /**
     * Esse método os elementos de posição par da lista.
     * 
     * @return A lista de elementos de posição par, incluindo o elemento da posição zero.
     * Ou seja os elementos 0, 2, 4, 6, 8 ...
     * 
    */
    //MEU METODO DO DESAFIO
    public ListaDuplamenteLigada<T> elementosDePosicaoPar(){
        
        //crio uma nova lista do tipo ListaSimplesmenteLigada que irá receber os elementos com posição par
        ListaDuplamenteLigada<T> listaComElementosDePosicaoPar = new ListaDuplamenteLigada<>();
        
        //crio uma variavel auxiliar que verifica se a posicao atual é a i-esima posicao
        int i=0;
        
        //fazendo com while
        NoDuplo<T> umNo = inicio;
        while (umNo != null){
            if(i % 2 == 0){
                listaComElementosDePosicaoPar.adicionaFim(umNo.getValor());
            }    
            i++;
            umNo = umNo.getProximo();
        
        }
        
        //fazendo com FOR
        /*
        //percorro a lista até chegar ao fim
        for(NoDuplo<T> umNo = inicio; umNo != null; i++){
            if(i%2==0){ //se o resto da divisão por 2 for 0, então a posicao é par
                //adiciono este nó na minha nova lista
                listaComElementosDePosicaoPar.adicionaFim(umNo.getValor());
            }
            
            //passo para o proximo no
            umNo = umNo.getProximo();
        }*/
        
        //retorno minha lista com elementos de posição par
        return listaComElementosDePosicaoPar;
    }
   
    
    
    /**
     * Esse método devolve a lista invertida.
     * 
     * @return A lista de elementos invertida. O último elemento passa a ser o primeiro,
     * o penúltimo o segundo, o antepenúltipo o terceiro e assim sucessivamente.
     * 
    *///MEU METODO DO DESAFIO 
    public ListaDuplamenteLigada<T> inverte(){
       //crio uma nova lista do tipo ListaSimplesmenteLigada que irá receber os elementos com posição par
        ListaDuplamenteLigada<T> listaInvertida = new ListaDuplamenteLigada<>();
        
        //crio uma variavel auxiliar
        int i=0;
        NoDuplo<T> umNo = inicio;
        
        //COM WHILE
        while (umNo != null){
            listaInvertida.adicionaInicio(umNo.getValor());
            umNo = umNo.getProximo();
        
        }
        
        //COM FOR
        //percorro a lista até chegar ao fim
        /*for(NoDuplo<T> umNo = inicio; umNo != null; i++){
            
            //adiciono este nó na minha nova lista apontando para o inicio
            listaInvertida.adicionaInicio(umNo.getValor());
            
            //passo para o proximo no
            umNo = umNo.getProximo();
        }*/
        
        //retorno minha lista com elementos invertidos
        return listaInvertida;
    }
    
    
    //acho que ta feito
    public boolean existe(No no) {
        NoDuplo<T> iterador = inicio;
        int aux=0;
        do{
            if(iterador.getValor().equals(no.getValor())){
                return true;
            }
            iterador = iterador.getProximo();
            aux++;
        }while(iterador!=null);
            
        return false;
    }

    
    public void atualizar(NoDuplo<T> no) throws ItemNaoEncontradoException {
        NoDuplo<T> anterior = null; 
        NoDuplo<T> iterador = inicio;
        
        do{
            if(iterador.getValor().equals(no.getValor())){
               if(anterior!=null){ 
                   anterior.setProximo(no);
               }else{
                   inicio = no;
               } 
               no.setProximo(iterador.getProximo());
               return;
            }
            
            anterior = iterador;
            iterador = iterador.getProximo();
        }while(iterador!=null);
            
        throw new ItemNaoEncontradoException();
    }

    public NoDuplo<T> consultar(NoDuplo<T> no) {
        return null;
    }
    
    
    public void remover(NoDuplo<T> no)  throws ItemNaoEncontradoException {
        NoDuplo<T> anterior = null; 
        NoDuplo<T> iterador = inicio;
        
        do{
            if(iterador.getValor().equals(no)){
               if (anterior!=null)
                   anterior.setProximo(iterador.getProximo());
               else
                   inicio = iterador.getProximo();
               
               iterador.setProximo(null);
               return;
            }
            anterior = iterador;
            iterador = iterador.getProximo();
        }while(iterador!=null);
            
        throw new ItemNaoEncontradoException();
    }
    
    //acho que ta ok
    public NoDuplo<T> removerInicio()  throws ItemNaoEncontradoException {
        
        if(inicio == null ){
            throw new ItemNaoEncontradoException();
        }
        
        NoDuplo<T> no = inicio;
        inicio = inicio.getProximo();
        no.setProximo(null);
        
        inicio.setAnterior(null);
        return no;
    }
    
    public NoDuplo<T> removerFim()  throws ItemNaoEncontradoException {
        NoDuplo<T> anterior = null; 
        NoDuplo<T> iterador = fim;
        
        if(iterador == null ){
            throw new ItemNaoEncontradoException();
        }
        
        while (iterador != null){
            if(iterador == fim){
                anterior.setProximo(null);
                fim = anterior;
                return iterador;
            }
            anterior = iterador;
            iterador = iterador.getProximo();
        }
        
        return null;
    }
    
    //ok
    public int tamanho() {
        int count;
        
        if (inicio == null){
            count = 0;
        } else {
            count = 1;
            NoDuplo<T> ultimoNo = inicio;
            while(ultimoNo.getProximo() != null){
                count++;
                ultimoNo = ultimoNo.getProximo();
            }
        }
        return count;
    }

    
    //ok
    public IteradorListaDuplamenteLigada<T> iterador() {
        return new IteradorListaDuplamenteLigada<>(this.inicio);
    }
    
    //ok
    @Override
    public String toString() {
        //Uso de string para concatenações não é recomendado. Veremos uma melhor forma em breve
        String lista;

        NoDuplo<T> interador = inicio;

        lista = "";
        while(interador != null){
            lista = lista+ " " + interador.getValor() + " \n";
            interador = interador.getProximo();
        }    
    

        return lista;
    }
}
