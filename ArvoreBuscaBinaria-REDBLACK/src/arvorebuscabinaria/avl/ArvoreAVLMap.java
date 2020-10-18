/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebuscabinaria.avl;

import java.util.Set;
import java.util.TreeSet;

public class ArvoreAVLMap<V> implements MyMap<Integer, V> {

    class No {

        private int chave, altura;
        private No esquerda, direita;
        private V valor;

        public No(Integer d, V valor) {
            chave = d;
            altura = 1;
            this.valor = valor;
        }

        public int getAltura() {
            return altura;
        }
    }

    private No raiz;

    @Override
    public int size() {
        if (raiz == null) {
            return 0;
        } else {
            return sizeAux(raiz);
        }
    }

    public int sizeAux(No umNo) {
        return 1 + sizeAux(umNo.esquerda) + sizeAux(umNo.direita);
    }

    @Override
    public void put(Integer key, V value) {
        raiz = inserir(raiz, key, value);
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsKey(Integer key) {
        //verifica se a chave está presente ou não
        if(get(key) != null)
            return true;
        else
            return false;
    }

    @Override
    public V get(Integer key) {
        return get(raiz, key);
        //percorro a arvore até encontrar a chave, e quando encontrar a chave eu retorno o valor dela;
    }

    private V get(No umNo, Comparable key) {
        if (umNo == null) {
            return null;
        }
        int compara = key.compareTo(umNo.chave);
        if (compara == 0) {
            return (V) umNo.valor;
        } else if (compara < 0) {
            return get(umNo.esquerda, key);
        } else if (compara > 0) {
            return get(umNo.direita, key);
        } else {
            return null;
        }
    }

    @Override
    public V remove(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        raiz = null;
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> set = new TreeSet<Integer>();
        keySetAux(raiz, set);
        return set;
    }

    protected void keySetAux(No umNo, Set<Integer> set) {
        if (umNo != null) {
            keySetAux(umNo.esquerda, set);
            set.add(umNo.chave);
            keySetAux(umNo.direita, set);
        }
    }

    private int altura(No N) {
        if (N == null) {
            return 0;
        }

        return N.getAltura();
    }

    private No rotacionaDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
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
        if (N == null) {
            return 0;
        }

        return altura(N.esquerda) - altura(N.direita);
    }

    private No inserir(No no, int chave, V valor) {

        if (no == null) {
            return (new No(chave, valor));
        }

        if (chave < no.chave) {
            no.esquerda = inserir(no.esquerda, chave, valor);
        } else if (chave > no.chave) {
            no.direita = inserir(no.direita, chave, valor);
        } else {
            return no;
        }

        //atualiza altura
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        //Baleceamento
        int balance = getBalanco(no);

        // LL		
        if (balance > 1 && chave < no.esquerda.chave) {
            return rotacionaDireita(no);
        }

        // RR
        if (balance < -1 && chave > no.direita.chave) {
            return rotacionaEsquerda(no);
        }

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

    /*public void inserir(int chave) {
		raiz = inserir(raiz, chave);
	}*/
    public static void main(String[] args) {
        ArvoreAVLMap tree = new ArvoreAVLMap();
        tree.put(1, 1);
        tree.put(2, 2);
        tree.put(3, 3);
        tree.containsKey(2);
        System.out.println("A chave '3' existe? " + tree.containsKey(3));
    }
}
