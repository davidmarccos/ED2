/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.controlador;

import david.entidades.Aluno;
import david.iteradores.IteradorListaSimplesmenteLigada;
import david.listas.ListaSimplesmenteLigada;

/**
 *
 * @author david
 */
public class ControladorAluno {
    private ListaSimplesmenteLigada<Aluno> alunos;
    
    public ControladorAluno(Aluno alunos[]) {
        this.alunos = new ListaSimplesmenteLigada<>(alunos);
    }
    
    
    public void inserirFim(Aluno a){
        this.alunos.adicionaFim(a);  //By pass
    }
    
    
    public void inserirInicio(Aluno a){
        this.alunos.adicionaInicio(a); //By pass
    }
    
    //METODOS DO DESAFIO 2 - COM GENERICS
    //ALUNO: DAVID MARCOS DE ALBUQUERQUE COSTA
    /*public double totalMensalidades(){
        No umNo = inicio;
        double valortotal=0;
        
        while (umNo != null) {
            //incremento o valor da mensalidade na minha variavel de valor total
            valortotal += umNo.getValor().getMensalidade();
            umNo = umNo.getProximo();
        }
        
        return valortotal;    
    }*/
    public double totalMensalidades() {
        
       IteradorListaSimplesmenteLigada<Aluno>  iterador = this.alunos.iterador();
               
       double valortotal=0;
        
        while (iterador.existeProximo()){
            Aluno aluno = iterador.getProximo();
            valortotal += aluno.getMensalidade();
        }
        
        return valortotal;
    }
    
    public ListaSimplesmenteLigada alunosComDesconto(){
        IteradorListaSimplesmenteLigada<Aluno>  iterador = this.alunos.iterador();
        
        //crio minha nova lista de alunos com desconto
        ListaSimplesmenteLigada listaAlunosComDesconto = new ListaSimplesmenteLigada();
        //No umNo = inicio;
        
        //sempre usar while ou do while quando trabalha com lista
        while (iterador.existeProximo()) {
            Aluno aluno = iterador.getProximo();
            if (aluno.getDesconto() != 0.0){ //verifico se o desconto desse no é maior que 0
                listaAlunosComDesconto.adicionaFim(aluno); //adiciono esse no na nova lista
            }
        }
        
        return listaAlunosComDesconto; //retorno minha lista com alunos com desconto
    }
    
    public ListaSimplesmenteLigada alunosComIdadeEntre(int idadeMinima, int idadeMaxima){
        
        //crio minha nova lista de alunos menores de idade
        ListaSimplesmenteLigada listaAlunosMenoresIdade = new ListaSimplesmenteLigada();
        
        IteradorListaSimplesmenteLigada<Aluno>  iterador = this.alunos.iterador();
        //No umNo = inicio; //aponto o no para o inicio
        
        while (iterador.existeProximo()) { //percorro toda a lista
            Aluno aluno = iterador.getProximo();
            //se a idade do nó estiver entre a idademinima e idademaxima, adiciono na minha nova lista
            if (aluno.getIdade() >= idadeMinima && aluno.getIdade() <= idadeMaxima){
                listaAlunosMenoresIdade.adicionaFim(aluno); //adiciono na lista nova
            }
            //umNo = umNo.getProximo(); //aponto para o proximo no
                    
        }
        //retorno a lista nova 
        return listaAlunosMenoresIdade;     
    }
    
    public String alunoComMaiorDesconto(ListaSimplesmenteLigada lista){
        float aux=0; //variavel para receber todos os valores de desconto
        String nome = "";  //variavel para receber o nome do aluno com maior desconto
        IteradorListaSimplesmenteLigada<Aluno>  iterador = this.alunos.iterador();
        //No umNo = listaAlunosMenoresIdade.getInicio(); //seto o no com o inicio da lista de alunos menores de idade
        
        while (iterador.existeProximo()) { //percorro a lista toda até o fim
            Aluno aluno = iterador.getProximo();
                        //vejo se o valor do desconto é menor que o valor da variavel auxiliar
                        if(aux < (aluno.getMensalidade() * (aluno.getDesconto()/100))){
                            nome = aluno.getNome();
                        }
                        aux = (aluno.getMensalidade() * (aluno.getDesconto()/100)); //aux recebe o valor do no atual
                        //umNo = umNo.getProximo(); //aponto para o proximo no
                    }
        return nome;
    }
    
    public ListaSimplesmenteLigada alunosComDesconto(float descontoMinimo, float descontoMaximo){
        //crio minha nova lista de alunos com desconto
        ListaSimplesmenteLigada listaAlunosComDescontoPorcentagem = new ListaSimplesmenteLigada();
        //No umNo = inicio;
        IteradorListaSimplesmenteLigada<Aluno>  iterador = this.alunos.iterador();
        
        if(descontoMinimo == 0.0 && descontoMinimo == 15.0){
            //OPÇÃO DE PEGAR OS DESCONTOS MAIORES QUE 15%
            while (iterador.existeProximo()) {
                Aluno aluno = iterador.getProximo();
            if (aluno.getDesconto() > 15.0){ //verifico se o desconto desse no é maior que 0
               listaAlunosComDescontoPorcentagem.adicionaFim(aluno); //adiciono esse no na nova lista
            }  
            //umNo = umNo.getProximo(); //passo para o proximo no
        }
        
        }else{
            //OPÇÃO DE PEGAR O DESCONTO ENTRE O DESCONTO MINIMO E MAXIMO
            while (iterador.existeProximo()) {
                Aluno aluno = iterador.getProximo();
                if (aluno.getDesconto() != 0.0){ //verifico se o desconto desse no é maior que 0
                    if(aluno.getDesconto() >= descontoMinimo && aluno.getDesconto() <= descontoMaximo){
                        listaAlunosComDescontoPorcentagem.adicionaFim(aluno); //adiciono esse no na nova lista
                    }
                }
                //umNo = umNo.getProximo(); //passo para o proximo no
            }
        }
        
        return listaAlunosComDescontoPorcentagem; //retorno minha lista com alunos com desconto selecionado
    }
    
    
    public double atualizarMensalidades(float percentualAcrescimo){
        //No umNo = inicio;
        IteradorListaSimplesmenteLigada<Aluno>  iterador = this.alunos.iterador();
        double aux =0.0; //crio uma variavel auxiliar
        double TotalMensalidadeSemAcrescimo =0.0, TotalMensalidadeComAcrescimo =0.0;
        
        while (iterador.existeProximo()) {
            Aluno aluno = iterador.getProximo();
            TotalMensalidadeSemAcrescimo += aluno.getMensalidade(); // pego a soma de todas as mensalidades sem acrescimo
            
            aux = aluno.getMensalidade(); //pego o valor atual da mensalidade
            aux += aux * (percentualAcrescimo/100); //adiciono o acrescimo na minha variavel auxiliar junto com o valor da mensalidade antiga
            
            TotalMensalidadeComAcrescimo += aux; //pego a soma de todas as mensalidades com acrescimo
            
            //mudo o valor antigo para o valor novo da mensalidade
            aluno.setMensalidade((float)aux);
            
            //umNo = umNo.getProximo(); //passo para o proximo no
        }
        
        double soma = TotalMensalidadeComAcrescimo - TotalMensalidadeSemAcrescimo;
        return soma;
    }
    
    
    public double atualizaMensalidades(float percentualDesconto){
        //No umNo = inicio;
        IteradorListaSimplesmenteLigada<Aluno>  iterador = this.alunos.iterador();
        double aux =0.0; //crio uma variavel auxiliar
        double TotalMensalidadeSemDesconto =0.0, TotalMensalidadeComDesconto =0.0;
        
        while (iterador.existeProximo()) {
            Aluno aluno = iterador.getProximo();
            TotalMensalidadeSemDesconto += aluno.getMensalidade(); // pego a soma de todas as mensalidades sem desconto
            
            aux = aluno.getMensalidade(); //pego o valor atual da mensalidade
            aux -= aux * (percentualDesconto/100); //adiciono o desconto na minha variavel auxiliar junto com o valor da mensalidade antiga
            
            TotalMensalidadeComDesconto += aux; //pego a soma de todas as mensalidades com acrescimo
            
            //mudo o valor antigo para o valor novo da mensalidade
            aluno.setMensalidade((float)aux);
            
            //umNo = umNo.getProximo(); //passo para o proximo no
        }
        
        double soma = TotalMensalidadeSemDesconto - TotalMensalidadeComDesconto;
        return soma;
    }
     //METODOS DO DESAFIO 2 - SEM GENERICS
    //ALUNO: DAVID MARCOS DE ALBUQUERQUE COSTA
    
    
   /* public double totalMensalidades(){
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
