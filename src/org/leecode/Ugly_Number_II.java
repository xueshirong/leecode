package org.leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ugly_Number_II {
	//-------solution 1: Time Limit Exceeded
	/**
     * @param n an integer
     * @return the nth prime number as description.
     */
    List<Integer> list = new ArrayList<Integer>();
    public int nthUglyNumber(int n) {
        //corner case
        int root = 0;
        int num = 0;
        while (num != n){
            root++;
            if (isUgly(root)){
                list.add(root);
                num++;
            }
        }
        return root;
    }
    private boolean isUgly(int x){
        while (x != 1){
            if (list.contains(x))
                return true;
                
            if (x % 2 == 0)
                x = x / 2;
            else if (x % 3 == 0)
                x = x / 3;
            else if (x % 5 == 0)
                x = x / 5;
            else
                return false;
        }
        return true;
    }
    
    //-------solution 2
    public int nthUglyNumber2(int n) {
    	Queue<Long> pq = new PriorityQueue<Long>();
        HashSet<Long> set = new HashSet<Long>();
        List<Integer> list = new ArrayList<Integer>();
        int index = 0;        
        set.add(Long.valueOf(1));
        pq.offer(Long.valueOf(1));
        while (!pq.isEmpty() && index < n){
            Long val = pq.poll();
            list.add(val.intValue());
            if (!set.contains(val * 2)){
                set.add(val * 2);
                pq.offer(val * 2);
            }
            if (!set.contains(val * 3)){
                set.add(val * 3);
                pq.offer(val * 3);
            }
            if (!set.contains(val * 5)){
                set.add(val * 5);
                pq.offer(val * 5);
            }
            index++;
        }
        return list.get(index - 1);
    }
}
