/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.listas;

import david.excessoes.PosicaoInvalidaException;
import david.excessoes.ItemNaoEncontradoException;
import david.iteradores.IteradorListaSimplesmenteLigada;
import david.no.No;

/**
 *
 * @author david
 */
public class ListaSimplesmenteLigada <T> {
    
    private No<T> inicio;
    private No<T> fim;

    public No<T> getInicio() {
        return inicio;
    }
    
    public ListaSimplesmenteLigada() {
        inicio = null;
        fim = null;
    }
    public ListaSimplesmenteLigada(T elementos[]) {
         for (T a : elementos) {
            this.adicionaFim(a);
        }
    }
    /*public ListaSimplesmenteLigada(T[] alunos) {
       for(T umAluno : alunos){
           this.adicionaFim(new No(umAluno));
       }
    }*/

    public void adicionaFim(T novo) {
        No<T> no = new No<>(novo);
        
        if (inicio == null){
            inicio = no;
        } else {
            fim.setProximo(no);
        }
        fim = no;
    }
    /*
    public void adicionaFim(No<T> novo) {
        
        if (inicio == null){
            inicio = novo;
        } else {
            fim.setProximo(novo);
        }
        fim = novo;
    }*/
    
    public void adicionaInicio(T novo) {
        No<T> no = new No<>(novo);
        no.setProximo(inicio);
        inicio = no;
        
        if (fim == null){
            fim = no;
        }
    }
    /*public void adicionaInicio(No<T> novo) {
        novo.setProximo(inicio);
        inicio = novo;
        
        if (fim == null){
            fim = novo;
        }
    }*/
    
    public void adicionaPos(No<T> novo,int pos) throws PosicaoInvalidaException{
        if (pos==0){
           novo.setProximo(inicio.getProximo());
           inicio = novo;
        } else {
            No<T> iterador = inicio;
            for(int count=0; count < (pos-1); count++){
                iterador = iterador.getProximo();
            } 
            novo.setProximo(iterador.getProximo());
            iterador.setProximo(novo);
        }
    }
    
    /**
     * Esse método devolve o elemento da i-ésima posição.
     * 
     * @para i Posição do elemento a ser recuperado na lista
     * 
     * @return Elemento da posição i ou null caso a posição não exista na lista.
     * 
    */
    //MEU METODO DO DESAFIO
    public No<T> elementoEm(int i) throws ItemNaoEncontradoException{
        
        //crio o elementoDesejado do tipo No que vai receber o elemento da i-esima posicao
        No<T> elementoDesejado = null;
        //crio uma variavel auxiliar que verifica se a posicao atual é a i-esima posicao
        int pos=0;
        
        //percorro a lista até chegar ao fim
        for(No<T> umNo = inicio; umNo != null; pos++){
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
    //Metodo do professor abaixo
    /*public No<T> elementoEm(int i){
        
        No<T> retorno = null;
        No<T> aux = inicio;
        int count = 0;
        
        
        while (aux != null) {
                
            if (count == i){
                retorno = aux.clone();
                break;
            }
            count++;   
            
            aux = aux.getProximo();
           
        }
        
        
        
        return retorno;    
    }*/
    
    /**
     * Esse método os elementos de posição par da lista.
     * 
     * @return A lista de elementos de posição par, incluindo o elemento da posição zero.
     * Ou seja os elementos 0, 2, 4, 6, 8 ...
     * 
    */
    //MEU METODO DO DESAFIO
    public ListaSimplesmenteLigada<T> elementosDePosicaoPar(){
        
        //crio uma nova lista do tipo ListaSimplesmenteLigada que irá receber os elementos com posição par
        ListaSimplesmenteLigada<T> listaComElementosDePosicaoPar = new ListaSimplesmenteLigada<>();
        
        //crio uma variavel auxiliar que verifica se a posicao atual é a i-esima posicao
        int i=0;
        
        //percorro a lista até chegar ao fim
        for(No<T> umNo = inicio; umNo != null; i++){
            if(i%2==0){ //se o resto da divisão por 2 for 0, então a posicao é par
                //adiciono este nó na minha nova lista
                listaComElementosDePosicaoPar.adicionaFim(umNo.getValor());
            }
            
            //passo para o proximo no
            umNo = umNo.getProximo();
        }
        
        //retorno minha lista com elementos de posição par
        return listaComElementosDePosicaoPar;
    }
    /*METODO DO PROFESSOR ABAIXO
    public ListaSimplesmenteLigada<T> elementosDePosicaoPar(){
        
        ListaSimplesmenteLigada<T> elementosPares = new ListaSimplesmenteLigada<T>();
        
        No<T> aux = inicio;
        int count = 0;
        
        
        while (aux != null) {
                
            if (count % 2 == 0){
                //elementosPares.adicionaFim(aux.clone()); antes de generics
                elementosPares.adicionaFim(aux.getValor());
            }
            count++;   
            aux = aux.getProximo();
                    
        }
        
        
        
        return elementosPares;        
    }*/
    
    
    
    /**
     * Esse método devolve a lista invertida.
     * 
     * @return A lista de elementos invertida. O último elemento passa a ser o primeiro,
     * o penúltimo o segundo, o antepenúltipo o terceiro e assim sucessivamente.
     * 
    */
    //MEU METODO DO DESAFIO 
    public ListaSimplesmenteLigada<T> inverte(){
       //crio uma nova lista do tipo ListaSimplesmenteLigada que irá receber os elementos com posição par
        ListaSimplesmenteLigada<T> listaInvertida = new ListaSimplesmenteLigada<>();
        
        //crio uma variavel auxiliar
        int i=0;
        
        //percorro a lista até chegar ao fim
        for(No<T> umNo = inicio; umNo != null; i++){
            
            //adiciono este nó na minha nova lista apontando para o inicio
            listaInvertida.adicionaInicio(umNo.getValor());
            
            //passo para o proximo no
            umNo = umNo.getProximo();
        }
        
        //retorno minha lista com elementos invertidos
        return listaInvertida;
    }
    /*METODO DO PROFESSOR
    public ListaSimplesmenteLigada<T> inverte(){
        
        ListaSimplesmenteLigada<T> auxiliar = new ListaSimplesmenteLigada<T>();
        
        No<T> iterador = inicio;
        
        while (iterador != null){
            //auxiliar.adicionaInicio(iterador.clone());
            auxiliar.adicionaInicio(iterador.getValor());
            
            iterador = iterador.getProximo();
        
        }
        
        return auxiliar;
    }*/
    
    public IteradorListaSimplesmenteLigada<T> iterador() {
        return new IteradorListaSimplesmenteLigada<>(this.inicio);
    }
    
    public boolean existe(No<T> no) {
        No<T> iterador = inicio;
        
        do{
            if(iterador.getValor().equals(no.getValor())){
                return true;
            }
            
            iterador = iterador.getProximo();
        }while(iterador!=null);
            
        return false;
    }

    public void atualizar(No<T> no) throws ItemNaoEncontradoException {
        No<T> anterior = null; 
        No<T> iterador = inicio;
        
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

    public No<T> consultar(No<T> no) {
        return null;
    }

    public void remover(No<T> no)  throws ItemNaoEncontradoException {
        No<T> anterior = null; 
        No<T> iterador = inicio;
        
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
    
    //para filas e PILHAS
    public No<T> removerFim()  throws ItemNaoEncontradoException {
        No<T> anterior = null; 
        No<T> umNo = fim;
        
        if(umNo == null){
            throw new ItemNaoEncontradoException();
        }
            
        while(umNo != null){
            if(umNo == fim){ //se cheguei no fim da lista
                anterior.setProximo(null);
                fim = anterior;
                return umNo;
            }
            
            anterior = umNo;
            umNo = umNo.getProximo();
        }
        
        return null; //nunca vai chegar aqui
    }
    
    //para fila e pilha
    public No<T> removerInicio()  throws ItemNaoEncontradoException {
        if(inicio == null ){
            throw new ItemNaoEncontradoException();
        }
            
        No<T> retorno = inicio;
        inicio = inicio.getProximo();
        retorno.setProximo(null);
        
        return retorno;
    }
    
    public int tamanho() {
        int count;
        
        if (inicio == null){
            count = 0;
        } else {
            count = 1;
            No<T> ultimoNo = inicio;
            while(ultimoNo.getProximo() != null){
                count++;
                ultimoNo = ultimoNo.getProximo();
            }
        }
        return count;
    }

    @Override
    public String toString() {
        //Uso de string para concatenações não é recomendado. Veremos uma melhor forma em breve
        String lista;

        No<T> interador = inicio;

        lista = "";
        while(interador != null){
            lista = lista+ " " + interador.getValor() + " \n";
            interador = interador.getProximo();
        }    
    

        return lista;
    }

    
    
    //METODOS DO DESAFIO 2
    //ALUNO: DAVID MARCOS DE ALBUQUERQUE COSTA
    
    /*
    public double totalMensalidades(){
        No umNo = inicio;
        double valortotal=0;
        
        while (umNo != null) {
            //incremento o valor da mensalidade na minha variavel de valor total
            valortotal += umNo.getValor().getMensalidade();
            umNo = umNo.getProximo();
        }
        
        return valortotal;    
    }
    
    
    public ListaSimplesmenteLigada alunosComDesconto(){
        
        //crio minha nova lista de alunos com desconto
        ListaSimplesmenteLigada listaAlunosComDesconto = new ListaSimplesmenteLigada();
        No umNo = inicio;
        
        //sempre usar while ou do while quando trabalha com lista
        while (umNo != null) {
            if (umNo.getValor().getDesconto() != 0.0){ //verifico se o desconto desse no é maior que 0
                listaAlunosComDesconto.adicionaFim(umNo.clone()); //adiciono esse no na nova lista
            }  
            umNo = umNo.getProximo(); //passo para o proximo no
        }
        
        return listaAlunosComDesconto; //retorno minha lista com alunos com desconto
    }
    
    public ListaSimplesmenteLigada alunosComIdadeEntre(int idadeMinima, int idadeMaxima){
        
        //crio minha nova lista de alunos menores de idade
        ListaSimplesmenteLigada listaAlunosMenoresIdade = new ListaSimplesmenteLigada();
        
        No umNo = inicio; //aponto o no para o inicio
        
        while (umNo != null) { //percorro toda a lista
            //se a idade do nó estiver entre a idademinima e idademaxima, adiciono na minha nova lista
            if (umNo.getValor().getIdade() >= idadeMinima && umNo.getValor().getIdade() <= idadeMaxima){
                listaAlunosMenoresIdade.adicionaFim(umNo.clone()); //adiciono na lista nova
            }
            umNo = umNo.getProximo(); //aponto para o proximo no
                    
        }
        //retorno a lista nova 
        return listaAlunosMenoresIdade;     
    }
    
    public ListaSimplesmenteLigada alunosComDesconto(float descontoMinimo, float descontoMaximo){
        //crio minha nova lista de alunos com desconto
        ListaSimplesmenteLigada listaAlunosComDescontoPorcentagem = new ListaSimplesmenteLigada();
        No umNo = inicio;
        
        if(descontoMinimo == 0.0 && descontoMinimo == 15.0){
            //OPÇÃO DE PEGAR OS DESCONTOS MAIORES QUE 15%
            while (umNo != null) {
            if (umNo.getValor().getDesconto() > 15.0){ //verifico se o desconto desse no é maior que 0
               listaAlunosComDescontoPorcentagem.adicionaFim(umNo.clone()); //adiciono esse no na nova lista
            }  
            umNo = umNo.getProximo(); //passo para o proximo no
        }
        
        }else{
            //OPÇÃO DE PEGAR O DESCONTO ENTRE O DESCONTO MINIMO E MAXIMO
            while (umNo != null) {
                if (umNo.getValor().getDesconto() != 0.0){ //verifico se o desconto desse no é maior que 0
                    if(umNo.getValor().getDesconto() >= descontoMinimo && umNo.getValor().getDesconto() <= descontoMaximo){
                        listaAlunosComDescontoPorcentagem.adicionaFim(umNo.clone()); //adiciono esse no na nova lista
                    }
                }
                umNo = umNo.getProximo(); //passo para o proximo no
            }
        }
        
        return listaAlunosComDescontoPorcentagem; //retorno minha lista com alunos com desconto selecionado
    }
    
    
    public double atualizarMensalidades(float percentualAcrescimo){
        No umNo = inicio;
        double aux =0.0; //crio uma variavel auxiliar
        double TotalMensalidadeSemAcrescimo =0.0, TotalMensalidadeComAcrescimo =0.0;
        
        while (umNo != null) {
            TotalMensalidadeSemAcrescimo += umNo.getValor().getMensalidade(); // pego a soma de todas as mensalidades sem acrescimo
            
            aux = umNo.getValor().getMensalidade(); //pego o valor atual da mensalidade
            aux += aux * (percentualAcrescimo/100); //adiciono o acrescimo na minha variavel auxiliar junto com o valor da mensalidade antiga
            
            TotalMensalidadeComAcrescimo += aux; //pego a soma de todas as mensalidades com acrescimo
            
            //mudo o valor antigo para o valor novo da mensalidade
            umNo.getValor().setMensalidade((float)aux);
            
            umNo = umNo.getProximo(); //passo para o proximo no
        }
        
        double soma = TotalMensalidadeComAcrescimo - TotalMensalidadeSemAcrescimo;
        return soma;
    }
    
    
    public double atualizaMensalidades(float percentualDesconto){
        No umNo = inicio;
        double aux =0.0; //crio uma variavel auxiliar
        double TotalMensalidadeSemDesconto =0.0, TotalMensalidadeComDesconto =0.0;
        
        while (umNo != null) {
            TotalMensalidadeSemDesconto += umNo.getValor().getMensalidade(); // pego a soma de todas as mensalidades sem desconto
            
            aux = umNo.getValor().getMensalidade(); //pego o valor atual da mensalidade
            aux -= aux * (percentualDesconto/100); //adiciono o desconto na minha variavel auxiliar junto com o valor da mensalidade antiga
            
            TotalMensalidadeComDesconto += aux; //pego a soma de todas as mensalidades com acrescimo
            
            //mudo o valor antigo para o valor novo da mensalidade
            umNo.getValor().setMensalidade((float)aux);
            
            umNo = umNo.getProximo(); //passo para o proximo no
        }
        
        double soma = TotalMensalidadeSemDesconto - TotalMensalidadeComDesconto;
        return soma;
    }*/
}

