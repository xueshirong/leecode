package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	//思路：典型的backtracking问题，用递归解比较简单易懂。这个方法在3sum那题中也有应用到。
    //扫描1:n的每个数i，对之后{i+1: n}的集合求k-1 combination问题。直到对某集合解0 combination问题时终止，并插入结果。
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> sol = new ArrayList<Integer>();
        List<List<Integer>> allSol = new ArrayList<List<Integer>>();
        helper(n, 1, k, sol, allSol);
        return allSol;
    }
    void helper(int n, int start, int k, List<Integer> sol, List<List<Integer>> allSol) {
        if(k==0) {
            allSol.add(new ArrayList(sol));
            return;
        }
        
        for(int i = start; i<=n-k+1; i++) {
            sol.add(i);
            helper(n, i+1, k-1, sol, allSol);
            sol.remove(sol.size() - 1);
        } 
    }
}
