package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Factor_Combinations {
	//numbers can be regarded as product of its factors. For example,
	//8 = 2 x 2 x 2;
	//	= 2 x 4.
	//Write a function that takes an integer n and return all possible combinations of its factors.
	
	//Note: 
	//You may assume that n is always positive.
	//Factors should be greater than 1 and less than n.
	
	//思路：
	//这题backtracking的妙处在于：把上限进行改变，这样可以减少很多计算。
	//上限n进行改变。最后需要注意的是，list.size() > 1的作用是把n本身去掉。
	//比如：n = 12， 结果会包括12本身，它只有一个，是不成立的。
	//这题必须得<=n，因为我是变上限，来求质因子，所以必须等于n才能整除。最后再用list.size() >1来去除本身。
	public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(n<=2) 
        	return lists;
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(lists, n, 2, list);
        return lists;
    }    
    public void helper(List<List<Integer>> lists, int n, int start, List<Integer> list) {
        if(n == 1) {
            if(list.size() >1){
                lists.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for(int i=start; i<=n; i++){
            if(n % i == 0){
                list.add(i);
                helper(lists, n/i, i, list);
                list.remove(list.size()-1);
            }
        }
    }
}
