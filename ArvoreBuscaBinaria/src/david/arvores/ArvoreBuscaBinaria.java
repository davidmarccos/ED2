/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.arvores;

import david.excessoes.ListaInexistenteException;
import david.excessoes.ItemJaExistenteException;
import david.listas.ListaSimplesmenteLigada;
import david.no.NoArvoreBuscaBinaria;

/**
 *
 * @author david
 * @param <T>
 */

//USANDO O COMPARABLE COMO O PROFESSOR ENSINOU
public class ArvoreBuscaBinaria<T extends Comparable<T>> {
    
    //crio a raiz
    private NoArvoreBuscaBinaria<T> raiz;
    
    //crio os construtores
    public NoArvoreBuscaBinaria<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvoreBuscaBinaria<T> raiz) {
        this.raiz = raiz;
    }
    
    //ATIVIDADE ABAIXO: CRIAR O LOCALIZAR E ADICIONAR
    //ALUNO DAVID MARCOS DE ALBUQUERQUE COSTA
    
    private void adicionar(NoArvoreBuscaBinaria<T> noAtual, T valor) {
       
        //verifico se o item já existe na arvore
        if (noAtual.getValor().equals(valor)) {
            //throw new ItemJaExistenteException(); //lanço a excessao
        } else if (noAtual == null) { //se o no é nulo
            noAtual.setValor(valor); //seto o no com o valor
        } else {
            int comparador = noAtual.compareTo(valor); //comparo o no com o valor
            if (comparador < 0) { //se o noatual é maior que valor, vai pra esquerda
                if (noAtual.getEsquerda() == null) { //se o no da esquerda for nulo
                    NoArvoreBuscaBinaria<T> novo = new NoArvoreBuscaBinaria<>(valor); //crio um no com o valor
                    noAtual.setEsquerda(novo); //adiciono o novo nó na esquerda
                } else {
                    adicionar(noAtual.getEsquerda(), valor); //faço a recursividade com o no da esquerda e o valor
                }
            } else if(comparador > 0) {//se o noatual é menor que valor, vai pra direita
                if (noAtual.getDireita() == null) {
                    NoArvoreBuscaBinaria<T> novo = new NoArvoreBuscaBinaria<>(valor);//crio um no com o valor
                    noAtual.setDireita(novo);//adiciono o novo nó na direita
                } else {
                    adicionar(noAtual.getDireita(), valor); //faço a recursividade com o no da direita e o valor
                }
            }else{
                noAtual.setValor(valor);
            }

        }
    }

    public void adicionar(T valor) {
        if (this.getRaiz() == null) { //se não existe no na arvore
            this.raiz = new NoArvoreBuscaBinaria<>(valor); //adiciono o valor na raiz
        } else { //se ja existe nó na arvore
            adicionar(this.raiz, valor); //chamo o adicionar para comparar
        }

    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public T localizar(T valor){
        return localizar(raiz,valor);
    }

    private T localizar(NoArvoreBuscaBinaria<T> raiz, T valor) {
        if(raiz == null){
            return null; //não há no na arvore para localizar
        }
        //crio o comparador que chama o compareTo para raiz e valor
        int comparador = raiz.compareTo(valor);
        
        if(comparador < 0){ //se o resultado do comparador for -1 é porque a raiz é maior que o valor
            return localizar(raiz.getEsquerda(), valor);//vou para esquerda, usando recursividade
        }else if(comparador > 0){ //comparador é 1, então raiz é menor que o valor
            return localizar(raiz.getDireita(), valor); //vou para direita, usando recursividade
        }else{ //se for nem maior nem menor é porque achou
            return valor; //retorno o valor
        }
    }
    
    //ATIVIDADE ABAIXO - DE CRIAR O REMOVER
    //ALUNO DAVID MARCOS DE ALBUQUERQUE COSTA
    
    public void remover(T valor) throws Exception{
        remover(raiz, valor);
    }
    public void remover(NoArvoreBuscaBinaria<T> umNo, T valor) throws Exception{
        //crio os comparadores que chama o compareTo para raiz e valor
        int comparador = umNo.compareTo(valor);
        int comparadorfilhoesquerda = umNo.getEsquerda().compareTo(valor);
        int comparadorfilhodireita = umNo.getDireita().compareTo(valor);
        
        
        if(raiz == null){
            throw new Exception("Árvore vazia");
        }
        else { 
            if(comparador < 0){ //if(valor < umNo.getvalor()) se o valor que procuro é menor que o no atual
                
                if(comparadorfilhoesquerda == 0){ //if(valor < umNo.getEsquerda().getvalor() se o no da esquerda for igual ao valor
                    
                    //verifico se o no a remover não tem filhos, SE ELE É UMA FOLHA
                    if(umNo.getEsquerda().getEsquerda() == null && umNo.getDireita().getDireita() == null){ //verifico se o no a remover não tem filhos
                        //confirmo que o no é uma folha, então apago o no
                        umNo.setEsquerda(null); //removo o no da esquerda do no atual
                    }
                    
                    //logo, verifico SE TEM SÓ 1 FILHO
                    if(umNo.getEsquerda().getEsquerda() != null && umNo.getDireita().getDireita() == null){ //logo o no que vou remover só tem 1 filho e está na ESQUERDA
                        umNo.setEsquerda(umNo.getEsquerda().getEsquerda()); //seto o filho do no a remover e passa a ser o filho do no atual
                    }
                    else if(umNo.getEsquerda().getEsquerda() == null && umNo.getDireita().getDireita() != null){ //logo o no que vou remover só tem 1 filho e está na DIREITA
                        umNo.setEsquerda(umNo.getEsquerda().getDireita()); //seto o filho do no a remover e passa a ser o filho do no atual
                    }
                    
                    //TEM DOIS FILHOS
                    if(umNo.getEsquerda().getEsquerda() != null && umNo.getDireita().getDireita() != null){
                        umNo.setValor(encontrarNoMinimo(umNo.getDireita()).getValor());
                        umNo.setDireita(removerNoMinimo(umNo.getDireita()));
                    }
                    
                }
                //não cheguei no nó desejado
                else{
                    remover(umNo.getEsquerda(), valor); //desco pro no esquerdo e o no atual vai ser o no esquerdo
                }
            } 
            else if(comparador > 0){ //valor > umNo.getValor() se o valor que procuro é maior que o no atual
          
                if(comparadorfilhodireita == 0){ //if(valor < umNo.getEsquerda().getvalor() se o no da esquerda for igual ao valor
                    
                    //verifico se o no a remover não tem filhos, se ele é uma folha
                    if(umNo.getEsquerda().getEsquerda() == null && umNo.getDireita().getDireita() == null){ 
                        //confirmo que o no é uma folha, então apago o no 
                        umNo.setDireita(null); //removo o no folha que está na direta do no atual
                    }
                    
                    //logo, verifico se tem 1 FILHO
                    //se o filho esta na direita
                    if(umNo.getDireita().getDireita() != null && umNo.getEsquerda().getEsquerda() == null){ //logo o no que vou remover só tem 1 filho e está na direita
                        umNo.setDireita(umNo.getDireita().getDireita()); //seto o filho do no a remover e passa a ser o filho do no atual
                    }
                    else if(umNo.getEsquerda().getEsquerda() != null && umNo.getDireita().getDireita() == null){ //logo o no que vou remover só tem 1 filho e está na ESQUERDA
                        umNo.setDireita(umNo.getDireita().getEsquerda()); //seto o filho do no a remover e passa a ser o filho do no atual
                    }
                    
                    //TEM DOIS FILHOS
                    if(umNo.getEsquerda().getEsquerda() != null && umNo.getDireita().getDireita() != null){
                        umNo.setValor(encontrarNoMinimo(umNo.getDireita()).getValor());
                        umNo.setDireita(removerNoMinimo(umNo.getDireita()));
                    }
                     
                }
                //não cheguei no nó desejado
                remover(umNo.getDireita(), valor); //desco pro no direito e o no atual vai ser o no direito
            }
        }
    }
    //quando se tem 2 filhos na arvore, encontrar o no com valor minimo
    private NoArvoreBuscaBinaria<T> encontrarNoMinimo(NoArvoreBuscaBinaria<T> umNo) {  
        if (umNo != null) {  
            while (umNo.getEsquerda() != null) {  //desco sempre a esquerda até achar o valor minimo
                umNo = umNo.getEsquerda();  
            }  
        }  
        return umNo;  
    }
    
    //quando se tem 2 filhos na arvore
    private NoArvoreBuscaBinaria<T> removerNoMinimo(NoArvoreBuscaBinaria<T> umNo) {  
        if (umNo == null) {  
            System.out.println("  ERRO ");  
        } else if (umNo.getEsquerda() != null) { 
            umNo.setEsquerda(removerNoMinimo(umNo.getEsquerda()));  
            return umNo;  
        } else {  
            return umNo.getDireita();  
        }  
        return null;  
    }  
    
    
    
    
    //ATIVIDADE ABAIXO - DE CRIAR O PRE-ORDEM POS-ORDEM E O EM-ORDEM
    //ALUNO DAVID MARCOS DE ALBUQUERQUE COSTA
    
    public ListaSimplesmenteLigada<T> PercorrerInOrdem(){
        if (raiz != null) { //se a raiz não for nula
            ListaSimplesmenteLigada<T> listaInOrdem = new ListaSimplesmenteLigada<>();
            return PercorrerInOrdem(raiz, listaInOrdem); //percorro a arvore
        }else{
            return null;
        }
    }
    
    public ListaSimplesmenteLigada<T> PercorrerInOrdem(NoArvoreBuscaBinaria<T> raiz, ListaSimplesmenteLigada<T> noLista){
       
        if (raiz.getEsquerda() != null) { //se o no da esquerda não for nulo 
            PercorrerInOrdem(raiz.getEsquerda(), noLista); //uso a recursividade apontando para a esquerda
        }
        noLista.adicionaFim(raiz.getValor()); //adiciono o no na lista ligada
        if (raiz.getDireita()!= null) {
            PercorrerInOrdem(raiz.getDireita(), noLista);
        }
        
        return noLista;
    }
    
    public ListaSimplesmenteLigada<T> PercorrerPreOrdem(){
        if (raiz != null){ 
            ListaSimplesmenteLigada<T> listaPreOrdem = new ListaSimplesmenteLigada<>();
            return PercorrerPreOrdem(raiz, listaPreOrdem);
        }else
            return null;
    }
    
    public ListaSimplesmenteLigada<T> PercorrerPreOrdem(NoArvoreBuscaBinaria<T> raiz, ListaSimplesmenteLigada<T> noLista){
        noLista.adicionaFim(raiz.getValor()); //adiciono o no na lista ligada
        if (raiz.getEsquerda() != null) {
            PercorrerPreOrdem(raiz.getEsquerda(), noLista);
        }
        if (raiz.getDireita() != null) {
            PercorrerPreOrdem(raiz.getDireita(), noLista);
        }
        return noLista;
    }
    
    public ListaSimplesmenteLigada<T> PercorrerPosOrdem(){
        if (raiz != null){ 
            ListaSimplesmenteLigada<T> listaPreOrdem = new ListaSimplesmenteLigada<>();
            return PercorrerPreOrdem(raiz, listaPreOrdem);
        }else
            return null;
    }
    
    public ListaSimplesmenteLigada<T> PercorrerPosOrdem(NoArvoreBuscaBinaria<T> raiz, ListaSimplesmenteLigada<T> noLista){
        
        if (raiz.getEsquerda() != null) {
            PercorrerPreOrdem(raiz.getEsquerda(), noLista);
        }
        if (raiz.getDireita() != null) {
            PercorrerPreOrdem(raiz.getDireita(), noLista);
        }
        noLista.adicionaFim(raiz.getValor()); //adiciono o no na lista ligada
        return noLista;
    }
}
