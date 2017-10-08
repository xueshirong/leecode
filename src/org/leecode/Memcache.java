package org.leecode;

import java.util.HashMap;
import java.util.Map;

class Time_Value{
    public int time;
    public int value;
    public int ttl;
    public Time_Value(int t, int v, int tt){
        time = t;
        value = v;
        ttl = tt;
    }
}
//Jiu Zhang
public class Memcache {
	Map<Integer, Time_Value> map;
	public static void main(String[] args){
		Memcache mem = new Memcache();
		
		int res = 0;
		res = mem.get(1, 0);
		System.out.println(res);
		mem.set(2, 1, 1, 2);
		res = mem.get(3, 1);
		System.out.println(res);
		res = mem.get(4, 1);
		System.out.println(res);
		res = mem.incr(5, 1, 1);
		System.out.println(res);
		mem.set(6, 1, 3, 0);
		res = mem.incr(7, 1, 1);
		System.out.println(res);
		res = mem.decr(8, 1, 1);
		System.out.println(res);
		res = mem.get(9, 1);
		System.out.println(res);
		mem.delete(10, 1);
		res = mem.get(11, 1);
		System.out.println(res);
		res = mem.incr(12, 1, 1);
		System.out.println(res);
	}
	
    public Memcache() {
        // do intialization if necessary
        map = new HashMap<Integer, Time_Value>();
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: An integer
     */
    public int get(int curtTime, int key) {
        // write your code here
        if (!map.containsKey(key))
            return Integer.MAX_VALUE;
        
        Time_Value tv = map.get(key);
        
        if (isExpired(curtTime, key, tv)){
            delete(curtTime, key);
            return Integer.MAX_VALUE;
        }
        
        return tv.value;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param value: An integer
     * @param ttl: An integer
     * @return: nothing
     */
    public void set(int curtTime, int key, int value, int ttl) {
        // write your code here
        if (!map.containsKey(key))
            map.put(key, new Time_Value(0, 0, 0));
        Time_Value tv = map.get(key);
        tv.time = curtTime;
        tv.value = value;
        tv.ttl = ttl;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: nothing
     */
    public void delete(int curtTime, int key) {
        // write your code here
        if (map.containsKey(key)){
            map.remove(key);
        }
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int incr(int curtTime, int key, int delta) {
        // write your code here
        if (!map.containsKey(key))
            return Integer.MAX_VALUE;
        
        Time_Value tv = map.get(key);
        
        if (isExpired(curtTime, key, tv)){
        	tv.value = Integer.MAX_VALUE;
        	return tv.value;
        }
        long tmp = tv.value + delta;
        if (tmp > Integer.MAX_VALUE)
        	tmp = Integer.MAX_VALUE;
        tv.value = (int)tmp;
        return tv.value;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int decr(int curtTime, int key, int delta) {
        // write your code here
        /*if (!map.containsKey(key))
            return Integer.MAX_VALUE;
        
        Time_Value tv = map.get(key);
        
        if (isExpired(curtTime, key, tv))
            return Integer.MAX_VALUE;
            
        long tmp = tv.value - delta;
        
        if (tmp > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int)tmp;*/
        return incr(curtTime, key, -1 * delta);
    }
    
    private boolean isExpired(int curtTime, int key, Time_Value tv){
        if (tv.ttl == 0)//lives forever
            return false;
            
        if (curtTime > tv.time + tv.ttl - 1){//expired
            delete(curtTime, key);
            return true;
        }
        return false;
    }
}
