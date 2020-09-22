/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.entidades;

/**
 *
 * @author david
 */
public class Aluno implements Comparable<Aluno>{

    private String nome;
    private String CPF;
    private int idade;
    public String matricula;
    public float mensalidade;
    public float desconto;

    
    public Aluno(String nome, String CPF, 
                   int idade, String matricula, float mensalidade, float desconto) {
        this.nome = nome;
        this.CPF = CPF;
        this.idade = idade;
        this.matricula = matricula;
        this.mensalidade = mensalidade;
        this.desconto = desconto;
    }
/*
    public Aluno(String nome) {
        this.nome = nome;
    }*/

    public Aluno(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    
    @Override
    public boolean equals(Object obj) {
        return (this.matricula.equals(
                    ((Aluno)obj).matricula)                
                );
    }
    
    @Override
    public String toString() {
        return matricula + " : " + nome;
    }
    
    
    public int compareTo(Aluno aluno) {
        return this.matricula.compareTo(aluno.matricula);
    }
}
