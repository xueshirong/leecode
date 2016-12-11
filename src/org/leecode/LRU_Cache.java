package org.leecode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class LRU_Cache {
	//----solution 1
	List<Integer> list;
    Hashtable<Integer, Integer> ht;
    int capacity;
    
    // @param capacity, an integer
    public LRU_Cache(int capacity) {
        list = new ArrayList<Integer>();
        ht = new Hashtable<Integer, Integer>();
        this.capacity = capacity;
        //[set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)]
        this.set(2, 1);
        this.set(1, 1);
        this.set(2, 3);
        this.set(4, 1);
		//System.out.println(this.get(2));
		
		System.out.println(this.get(1));
		System.out.println(this.get(2));
    }

    // @return an integer
    public int get(int key) {
    	int index = list.indexOf(key);
        if (index > -1){
            list.remove(index);
            list.add(key);
            return ht.get(key);
        }else
            return -1;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (ht.containsKey(key)){
            ht.put(key,value);
            list.remove(list.indexOf(key));
            list.add(key);
            return;
        }
        
        if (list.size() == capacity){
            int tmep = list.get(0);
            ht.remove(tmep);
            list.remove(0);
        }
        
        ht.put(key, value);
        list.add(key);
    }
}
