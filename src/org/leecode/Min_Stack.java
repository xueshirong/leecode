package org.leecode;

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
