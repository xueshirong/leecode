package org.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Six_digit_number_equal {
	//求所有前三位和等于后三位和的六位正整数  bloomburg
	public static void main(String[] args){
        List<Integer> res = find2();
        Collections.sort(res);
        System.out.println(res.size());
        System.out.println(res);
    }
	
	private static List<Integer> find1(){
        Set<Integer> set = new HashSet<Integer>();
        Map<Integer, List<Integer>> mapleft = new HashMap<Integer, List<Integer>>();
        for (int i = 100; i < 1000; i++){
            int sum = helper(i);
            if (mapleft.containsKey(sum)){
                mapleft.get(sum).add(i);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                mapleft.put(sum, list);
            }
        }
        for (int i = 0; i < 1000; i++){
            int sum = helper(i);
            if (!mapleft.containsKey(sum))
                continue;
            List<Integer> list = mapleft.get(sum);
            for (int val : list){
                set.add(val * 1000 + i);;
            }
        }
        return new ArrayList<Integer>(set);
    }
	
	//solution 2
    private static List<Integer> find2(){
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 100000; i < 1000000; i ++){
            int a = (int)Math.pow(10,3);
            int sumleft = helper(i / a);
            int sumright = helper(i % a);
            if (sumleft == sumright)
                res.add(i);
        }
        return res;
    }
    private static int helper(int num){
        int sum = 0;
        while (num != 0){
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
