/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebuscabinaria.avl;

/**
 *
 * @author minci
 */
import java.util.Set;

public interface MyMap <KInteger, V>{

	    int size();

	    boolean isEmpty();

	    boolean containsKey(Integer key);

	    V get(Integer key);

	    void put(Integer key, V value);

	    V remove(Integer key);

	    void clear();

	    Set<Integer> keySet();

}
