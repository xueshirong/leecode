package org.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.leecode.Nested_List_Weight_Sum.NestedInteger;

public class Nested_List_Weight_Sum_II {
	//这道题是之前那道Nested List Weight Sum的拓展，与其不同的是，这道题的深度越深，权重越小，和之前刚好相反。
	//但是解题思路没有变，还可以用DFS来做，那么由于遍历的时候不知道最终的depth有多深，则不能遍历的时候就直接累加结果.
	//key: 如果说第一道题的关键是记录层次，那么这一题的关键是把这一层的integer sum传到下一层去
	public int depthSumInverse(List<NestedInteger> nestedList) {
	    return DFS(nestedList, 0);
	}
	
	public int DFS(List<NestedInteger> nestedList, int intSum) {
	    //关键点在于把上一层的integer sum传到下一层去，这样的话，接下来还有几层，
		//每一层都会加上这个integer sum,也就等于乘以了它的层数
	    List<NestedInteger> nextLevel = new ArrayList<>();
	    int listSum = 0;
	    for (NestedInteger list : nestedList) {
	        if (list.isInteger()) {
	            intSum += list.getInteger();
	        } else {
	            nextLevel.addAll(list.getList());
	        }
	    }
	    listSum = nextLevel.isEmpty() ? 0 : DFS(nextLevel, intSum);
	    return listSum + intSum;
	}
	
	//BFS
	int depthSumInverse2(List<NestedInteger> nestedList) {
		if (nestedList == null) return 0;
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        int prev = 0;
        int total = 0;
        for (NestedInteger next: nestedList) {
            queue.offer(next);
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger current = queue.poll();
                if (current.isInteger()) levelSum += current.getInteger();
                List<NestedInteger> nextList = current.getList();
                if (nextList != null) {
                    for (NestedInteger next: nextList) {
                        queue.offer(next);
                    }
                }
            }
            prev += levelSum;
            total += prev;
        }
        return total;
    }
}
