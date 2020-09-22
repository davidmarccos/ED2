/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import david.arvores.ArvoreBuscaBinaria;
import david.controlador.ControladorAluno;
import david.listas.ListaSimplesmenteLigada;
import david.entidades.Aluno;
import david.excessoes.ItemJaExistenteException;
import david.excessoes.ItemNaoEncontradoException;
import david.listas.ListaDuplamenteLigada;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Main {

    static Aluno[] alunos = {
        new Aluno("Catapóbio",  "00000000000", 22, "000000", 600.00f, 0.00f),
        new Aluno("Saponácio",  "11111111111", 23, "111111", 300.00f, 0.00f),
        new Aluno("Fulustreco", "22222222222", 20, "222222", 1500.00f, 10.00f),
        new Aluno("Coníglio",   "33333333333", 17, "333333", 4400.00f, 30.00f),
        new Aluno("Austin",     "44444444444", 16, "444444", 3000.00f, 30.00f),
        new Aluno("Antonio",    "55555555555", 22, "555555", 400.00f, 0.00f),
        new Aluno("Tj",         "66666666666", 40, "666666", 545.00f, 0.00f),
        new Aluno("Márcio",     "77777777777", 43, "777777", 560.00f, 10.00f),
        new Aluno("Ana",        "88888888888", 20, "888888", 800.00f, 15.00f),
        new Aluno("Maria",      "99999999999", 19, "999999", 1500.00f, 100.00f),
    
    };
    
    
    //Retornar a soma de todas as mensalidades dos alunos da lista
    //  * Criar método public double totalMensalidades()
    
    //Criar uma lista com os alunos que possuem desconto e exibir o valor total do desconto em reais.
    //  * Criar método public ListaSimplesmenteEncadeada alunosComDesconto()
    
    //Criar uma lista com os alunos menores de idade e exibir o nome do aluno com o maior valor de desconto dentre eles.
    //  * Criar método public ListaSimplesmenteEncadeada alunosComIdadeEntre(int idadeMinima, int idadeMaxima)
    
    //Criar uma lista com os alunos com desconto maiores que 15%
    //  * Criar método public ListaSimplesmenteEncadeada alunosComDesconto(float descontoMinimo, float descontoMaximo)
    
    //Criar um método que atualize todas as mensalidades dado um percentual de acréscimo e retorne o valor total em reais do acréscimo dado (Soma das mensalidades com acréscimo - Soma das mensalidades sem acrescimo).
    //  * Criar método public double atualizarMensalidades(float percentualAcrescimo)
    
    //Criar um método que atualize todas as mensalidades dado um percentual de desconto e retorne o valor total em reais do desconto dado (Soma das mensalidades sem desconto - Soma das mensalidades com desconto).
    //  * Criar método public double atualizarMensalidades(float percentualDesconto)
    static Scanner s = new Scanner(System.in);
    
    private static int menu(){
        System.out.println("Menu");
        System.out.println("1 - Retornar a soma de todas as mensalidades dos alunos da lista");
        System.out.println("2 - Criar uma lista com os alunos que possuem desconto e exibir o valor total do desconto em reais.");
        System.out.println("3 - Criar uma lista com os alunos menores de idade e exibir o nome do aluno com o maior valor de desconto dentre eles.");
        System.out.println("4 - Criar uma lista com os alunos com desconto maiores que 15%");
        System.out.println("5 - Atualize todas as mensalidades dado um percentual de acréscimo e retorne o valor total em reais do acréscimo dado");
        System.out.println("6 - Atualize todas as mensalidades dado um percentual de desconto e retorne o valor total em reais do desconto dado");
        System.out.println("7 - Para sair");
        System.out.println("8 - Lista dupla");
        System.out.println("9 - Arvore de Busca Binaria - localizar e adicionar");
        System.out.println("10 - Arvore de Busca Binaria - pos pre e inorder");
        System.out.println("11 - Arvore de Busca Binaria - REMOVER");
        System.out.println("Opção: ");
        int opcao = s.nextInt();
        s.nextLine();
        return opcao;
    }
    
    public static void main(String[] args) throws ItemJaExistenteException {
        
        ControladorAluno alunoControlador = new ControladorAluno(alunos);
        ListaDuplamenteLigada<Aluno> minhaLista = new ListaDuplamenteLigada<>(alunos);

        //inicializo a minhaLista
        //ListaSimplesmenteLigada<Aluno> minhaLista = new ListaSimplesmenteLigada<>(alunos);

        int opcao;
        do{
            opcao = menu();
            
            switch(opcao){
                case 1:{
                    System.out.println("a soma de todas as mensalidades dos alunos da lista é R$: "+ alunoControlador.totalMensalidades());
                    break;
                }
                case 2:{
                    ControladorAluno listaAlunosComDesconto = new ControladorAluno(alunos);
                    //ListaSimplesmenteLigada listaAlunosComDesconto = alunoControlador.alunosComDesconto();
                    System.out.println("lista com os alunos que possuem desconto: \n"+ listaAlunosComDesconto);
                    float valortotalDesconto=0; //variavel para receber todos os valores de desconto
                    //ISSO VAI PARA O CONTROLADOR
                    /*No umNo = listaAlunosComDesconto.getInicio();
                    while (umNo != null) { //percorro a lista toda até o fim
                        //incremento o valor do desconto na minha variavel de valor total
                        valortotalDesconto += umNo.getValor().getMensalidade() * (umNo.getValor().getDesconto()/100);
                        umNo = umNo.getProximo(); //aponto para o proximo no
                    }*/
                    //imprimo o valor total de descontos
                    System.out.println("\nvalor total do desconto em reais é R$: "+ valortotalDesconto);
                    break;
                }
                case 3:{
                    //pego o valor da idade minima
                    System.out.println("Digite a idade mínima: ");
                    int idademinima = s.nextInt();
                    s.nextLine();
                    
                    //pego o valor da idade maxima
                    System.out.println("Digite a idade maxima: ");
                    int idademaxima = s.nextInt();
                    s.nextLine();
                    
                    //crio uma lista de menores de idade recebendo a chamada do metodo de geração da lista
                    ListaSimplesmenteLigada listaAlunosMenoresIdade = alunoControlador.alunosComIdadeEntre(idademinima, idademaxima);
                    
                    //imprimo a lista
                    System.out.println("lista com os alunos menores de idade:\n "+ listaAlunosMenoresIdade);
                    
                    
                    //imprimo o nome do aluno que tem o maior desconto
                    System.out.println("\no nome do aluno com o maior valor de desconto dentre eles é: "+ alunoControlador.alunoComMaiorDesconto(listaAlunosMenoresIdade));
                    break;
                }
                case 4:{
                    //pego o valor da DESCONTO minimo
                    System.out.println("Digite o desconto minimo: ");
                    float descontominimo = s.nextInt();
                    s.nextLine();
                    
                    //pego o valor da DESCONTO maximo
                    System.out.println("Digite o desconto maximo: ");
                    float descontomaximo = s.nextInt();
                    s.nextLine();
                    
                    //crio uma lista de menores de idade recebendo a chamada do metodo de geração da lista
                    //lista que recebe o desconto maior que 15%
                    ListaSimplesmenteLigada listaAlunosDescontoMaiorQue15 = alunoControlador.alunosComDesconto(15, 100);
                    
                    //lista que recebe o desconto entre um valor maximo e minimo
                    ListaSimplesmenteLigada listaAlunosDescontoMaiorEntre = alunoControlador.alunosComDesconto(descontominimo, descontomaximo);
                    
                    //imprimo a lista com desconto minimo e maximo dado pelo usuario
                    System.out.println("lista com os alunos com desconto entre um valor minimo e maximo digitado:\n "+ listaAlunosDescontoMaiorEntre);
                    
                    //imprimo a lista com desconto maior que 15%
                    System.out.println("lista com os alunos com desconto maiores que 15%:\n "+ listaAlunosDescontoMaiorQue15);
                    break;
                }case 5:{
                    //pego o valor da DESCONTO minimo
                    System.out.println("Digite o percentual de acrescimo desejado para as mensalidades: ");
                    double percentualAcrescimo = s.nextDouble();
                    //s.nextLine();
                    
                    //imprimo o resultado da soma do acrescimo fazendo a chamada do metodo
                    System.out.println("o valor total em reais do acréscimo dado (Soma das mensalidades com acréscimo - Soma das mensalidades sem acrescimo) é  R$: "+ alunoControlador.atualizarMensalidades((float)percentualAcrescimo));
                    
                    break;
                }case 6:{
                    //pego o valor da DESCONTO minimo
                    System.out.println("Digite o percentual de desconto desejado para as mensalidades: ");
                    double percentualDesconto = s.nextDouble();
                    s.nextLine();
                    
                    //imprimo o resultado da soma do acrescimo fazendo a chamada do metodo
                    System.out.println("o valor total em reais do desconto dado (Soma das mensalidades sem desconto - Soma das mensalidades com desconto) é  R$: "+ alunoControlador.atualizaMensalidades((float)percentualDesconto));
                    
                    break;
                }case 8:{
                    //imprimo o resultado da soma do acrescimo fazendo a chamada do metodo
                    System.out.println("LISTA DUPLA INVERTIDA: "+ minhaLista.inverte());
                    
                try {
                    System.out.println("ELEMENTO 2: "+ minhaLista.elementoEm(2));
                } catch (ItemNaoEncontradoException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                    break;
                }case 9:{
                    System.out.println("ADICIONAR: ");
                    ArvoreBuscaBinaria<Aluno> arvore = new ArvoreBuscaBinaria<>();

                    arvore.adicionar(alunos[1]);
                    arvore.adicionar(alunos[3]);
                    arvore.adicionar(alunos[5]);
                    arvore.adicionar(alunos[2]);
                    arvore.adicionar(alunos[7]);
                    arvore.adicionar(alunos[8]);
                    arvore.adicionar(alunos[4]);
                    arvore.adicionar(alunos[2]);
                    
                    System.out.println("localizar: ");
                    
                    arvore.localizar(new Aluno("555555"));
                    break;
                }case 10:{
                    ArvoreBuscaBinaria<Aluno> arvore = new ArvoreBuscaBinaria<>();
                    arvore.adicionar(alunos[1]);
                    arvore.adicionar(alunos[3]);
                    arvore.adicionar(alunos[5]);
                    arvore.adicionar(alunos[2]);
                    arvore.adicionar(alunos[7]);
                    arvore.adicionar(alunos[8]);
                    arvore.adicionar(alunos[4]);
                    arvore.adicionar(alunos[2]);
                    
                    ListaSimplesmenteLigada<Aluno> listainorder = arvore.PercorrerInOrdem();
                    ListaSimplesmenteLigada<Aluno> listaposorder = arvore.PercorrerPosOrdem();
                    ListaSimplesmenteLigada<Aluno> listapreorder = arvore.PercorrerPreOrdem();
                    
                    
                    
                    System.out.println("INORDER: " + listainorder);
                    System.out.println("POSORDER: "+ listaposorder);
                    System.out.println("PREORDER: "+ listapreorder);
                    break;
                }
                case 11:{
                    ArvoreBuscaBinaria<Aluno> arvore = new ArvoreBuscaBinaria<>();
                    arvore.adicionar(alunos[1]);
                    arvore.adicionar(alunos[3]);
                    arvore.adicionar(alunos[5]);
                    arvore.adicionar(alunos[2]);
                    arvore.adicionar(alunos[7]);
                    arvore.adicionar(alunos[8]);
                    arvore.adicionar(alunos[4]);
                    arvore.adicionar(alunos[2]);
                    
                    
                    try {
                        System.out.println("Removendo  ");
                        arvore.remover(alunos[4]);
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                }
                default:
                    throw new IllegalArgumentException("Unexpected value:"+ opcao);
            }
            
        }while(opcao !=7);
        
        
        
        
        //SEM GENERICS
        /*
        //inicializo a minhaLista
        ListaSimplesmenteLigada<Aluno> minhaLista = new ListaSimplesmenteLigada<>(alunos);

        int opcao;
        do{
            opcao = menu();
            
            switch(opcao){
                case 1:{
                    System.out.println("a soma de todas as mensalidades dos alunos da lista é R$: "+ minhaLista.totalMensalidades());
                    break;
                }
                case 2:{
                    
                    ListaSimplesmenteLigada listaAlunosComDesconto = minhaLista.alunosComDesconto();
                    System.out.println("lista com os alunos que possuem desconto: \n"+ listaAlunosComDesconto);
                    
                    float valortotalDesconto=0; //variavel para receber todos os valores de desconto
                    No umNo = listaAlunosComDesconto.getInicio();
                    while (umNo != null) { //percorro a lista toda até o fim
                        //incremento o valor do desconto na minha variavel de valor total
                        valortotalDesconto += umNo.getValor().getMensalidade() * (umNo.getValor().getDesconto()/100);
                        umNo = umNo.getProximo(); //aponto para o proximo no
                    }
                    //imprimo o valor total de descontos
                    System.out.println("\nvalor total do desconto em reais é R$: "+ valortotalDesconto);
                    break;
                }
                case 3:{
                    //pego o valor da idade minima
                    System.out.println("Digite a idade mínima: ");
                    int idademinima = s.nextInt();
                    s.nextLine();
                    
                    //pego o valor da idade maxima
                    System.out.println("Digite a idade maxima: ");
                    int idademaxima = s.nextInt();
                    s.nextLine();
                    
                    //crio uma lista de menores de idade recebendo a chamada do metodo de geração da lista
                    ListaSimplesmenteLigada listaAlunosMenoresIdade = minhaLista.alunosComIdadeEntre(idademinima, idademaxima);
                    
                    //imprimo a lista
                    System.out.println("lista com os alunos menores de idade:\n "+ listaAlunosMenoresIdade);
                    
                    float aux=0; //variavel para receber todos os valores de desconto
                    String nome = "";  //variavel para receber o nome do aluno com maior desconto
                    No umNo = listaAlunosMenoresIdade.getInicio(); //seto o no com o inicio da lista de alunos menores de idade
                    while (umNo != null) { //percorro a lista toda até o fim
                        //vejo se o valor do desconto é menor que o valor da variavel auxiliar
                        if(aux < (umNo.getValor().getMensalidade() * (umNo.getValor().getDesconto()/100))){
                            nome = umNo.getValor().getNome();
                        }
                        aux = (umNo.getValor().getMensalidade() * (umNo.getValor().getDesconto()/100)); //aux recebe o valor do no atual
                        umNo = umNo.getProximo(); //aponto para o proximo no
                    }
                    //imprimo o nome do aluno que tem o maior desconto
                    System.out.println("\no nome do aluno com o maior valor de desconto dentre eles é: "+ nome);
                    break;
                }
                case 4:{
                    //pego o valor da DESCONTO minimo
                    System.out.println("Digite o desconto minimo: ");
                    float descontominimo = s.nextInt();
                    s.nextLine();
                    
                    //pego o valor da DESCONTO maximo
                    System.out.println("Digite o desconto maximo: ");
                    float descontomaximo = s.nextInt();
                    s.nextLine();
                    
                    //crio uma lista de menores de idade recebendo a chamada do metodo de geração da lista
                    //lista que recebe o desconto maior que 15%
                    ListaSimplesmenteLigada listaAlunosDescontoMaiorQue15 = minhaLista.alunosComDesconto(15, 100);
                    
                    //lista que recebe o desconto entre um valor maximo e minimo
                    ListaSimplesmenteLigada listaAlunosDescontoMaiorEntre = minhaLista.alunosComDesconto(descontominimo, descontomaximo);
                    
                    //imprimo a lista com desconto minimo e maximo dado pelo usuario
                    System.out.println("lista com os alunos com desconto entre um valor minimo e maximo digitado:\n "+ listaAlunosDescontoMaiorEntre);
                    
                    //imprimo a lista com desconto maior que 15%
                    System.out.println("lista com os alunos com desconto maiores que 15%:\n "+ listaAlunosDescontoMaiorQue15);
                    break;
                }case 5:{
                    //pego o valor da DESCONTO minimo
                    System.out.println("Digite o percentual de acrescimo desejado para as mensalidades: ");
                    double percentualAcrescimo = s.nextDouble();
                    //s.nextLine();
                    
                    //imprimo o resultado da soma do acrescimo fazendo a chamada do metodo
                    System.out.println("o valor total em reais do acréscimo dado (Soma das mensalidades com acréscimo - Soma das mensalidades sem acrescimo) é  R$: "+ minhaLista.atualizarMensalidades((float)percentualAcrescimo));
                    
                    break;
                }case 6:{
                    //pego o valor da DESCONTO minimo
                    System.out.println("Digite o percentual de desconto desejado para as mensalidades: ");
                    double percentualDesconto = s.nextDouble();
                    s.nextLine();
                    
                    //imprimo o resultado da soma do acrescimo fazendo a chamada do metodo
                    System.out.println("o valor total em reais do desconto dado (Soma das mensalidades sem desconto - Soma das mensalidades com desconto) é  R$: "+ minhaLista.atualizaMensalidades((float)percentualDesconto));
                    
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unexpected value:"+ opcao);
            }
            
        }while(opcao !=7);*/
    }
    
    
}