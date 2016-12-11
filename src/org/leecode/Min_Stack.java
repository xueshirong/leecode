package org.leecode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Min_Stack {
	/** initialize your data structure here. */
	/** initialize your data structure here. */
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    public Min_Stack() {
        
    }
    //shold be "<=" to add all minimum value to stack
    //when pop the min value -3, the other -3 still keep in stack
    public void push(int x) {
        if (min.empty()){
        	min.push(x);
        }else if (!min.empty() && x <= min.peek()){
            min.push(x);
        }
        in.push(x);
    }
    
    public void pop() {
        if(in.empty()) return;
        if(in.peek().equals(min.peek())) //use equals to check. "==" will not work.
            min.pop();
        in.pop();
    }
    
    public int top() {
        //if(in.empty()) return 0;
        if (!in.empty())
            return in.peek();
        return 0;
    }
    
    public int getMin() {
        if (!min.empty())
            return min.peek();
        return 0;
    }
}

class MinStack2 {
    //to save min vals
    PriorityQueue<Integer> q;
    Stack<Integer> stack;
    Queue<Integer> qq;
    
    public MinStack2() {
        // do initialize if necessary
        q = new PriorityQueue<Integer>();
        stack = new Stack<Integer>();
        qq = new LinkedList<Integer>();
    }

    public void push(int number) {
    	qq.add(number);
    	qq.offer(number);
    	qq.poll();
    	qq.peek();
    	qq.isEmpty();
    	
    	q.add(number);
    	q.offer(number);
    	q.poll();
    	q.peek();
    	q.isEmpty();
    	
    	stack.add(number);
    	stack.pop();
    	stack.peek();
    	stack.isEmpty();
    }
}
//---solution 3
class MinStack3 {
	Stack<Integer> res;
    Stack<Integer> minS;
    /** initialize your data structure here. */
    public MinStack3() {
        res = new Stack<Integer>();
        minS = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (!minS.isEmpty())
            minS.push(Math.min(x, minS.peek()));
        else
            minS.push(x);
            
        res.push(x);
    }
    
    public void pop() {
        res.pop();
        minS.pop();
    }
    
    public int top() {
        return res.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
}
