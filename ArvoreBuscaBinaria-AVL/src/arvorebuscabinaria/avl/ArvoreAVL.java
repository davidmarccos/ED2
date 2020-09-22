/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebuscabinaria.avl;

public class ArvoreAVL{
	class No {
		private int chave, altura;
		private No esquerda, direita;

		public No(int d) {
			chave = d;
			altura = 1;
		}

		public int getAltura() {
			return altura;
		}
	}

	private No raiz;

	private int altura(No N) {
		if (N == null)
			return 0;

		return N.getAltura();
	}

	private No rotacionaDireita(No y) {
		No x = y.esquerda;
		No T2 = x.direita;

		x.direita = y;
		y.esquerda = T2;

		y.altura = Math.max(altura(y.esquerda), altura(y.direita)) +1;
		x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
		return x;
	}

	private No rotacionaEsquerda(No x) {
		No y = x.direita;
		No T2 = y.esquerda;

		y.esquerda = x;
		x.direita = T2;

		x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
		y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
		return y;
	}

	private int getBalanco(No N) {
		if (N == null)
			return 0;

		return altura(N.esquerda) - altura(N.direita);
	}
	
	private No inserir(No no, int chave) {

		if (no == null)
			return (new No(chave));

		if (chave < no.chave)
			no.esquerda = inserir(no.esquerda, chave);
		else if (chave > no.chave)
			no.direita = inserir(no.direita, chave);
		else
			return no;

		//atualiza altura
		no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

		//Baleceamento
		int balance = getBalanco(no);

		// LL		
		if (balance > 1 && chave < no.esquerda.chave)
			return rotacionaDireita(no);

		// RR
		if (balance < -1 && chave > no.direita.chave)
			return rotacionaEsquerda(no);

		// LR
		if (balance > 1 && chave > no.esquerda.chave) {
			no.esquerda = rotacionaEsquerda(no.esquerda);
			return rotacionaDireita(no);
		}

		// RL
		if (balance < -1 && chave < no.direita.chave) {
			no.direita = rotacionaDireita(no.direita);
			return rotacionaEsquerda(no);
		}

		return no;
	}
	
	public void inserir(int chave) {
		raiz = inserir(raiz, chave);
	}

	public static void main(String[] args) {
		ArvoreAVL tree = new ArvoreAVL();
		tree.inserir(1);
		tree.inserir(2);
		tree.inserir(3);
	}
}
