package org.leecode;

import java.util.Stack;

public class Implement_Queue_by_Two_Stacks {
	public Implement_Queue_by_Two_Stacks(){
		Queues qu = new Queues();
		qu.push(1);
		qu.push(2); 
		qu.push(3);
		System.out.println(qu.top());
		System.out.println(qu.pop());
		System.out.println(qu.pop());
		qu.push(4);
		System.out.println(qu.top());
	}	
}
//stack1 is saving all input val
//stack2 is saving all output val
//when stack2 is not empty, pop from stack2
//when stack2 is empty, copy stack1 to stack2, then pop stack2 to get val
class Queues {
	private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public Queues() {
        // do initialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        while(stack2.isEmpty()){
            copy1to2();
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        while(stack2.isEmpty()){
            copy1to2();
        }
        return stack2.peek();
    }
    
    public void copy1to2(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    /*private void stack2ToStack1() {
		while (! stack2.empty()) {
			stack1.push(stack2.pop());			
		}
	}
	
    public void push(int number) {
        stack2.push(number);
    }

    public int pop() {
        if (stack1.empty() == true) {
			this.stack2ToStack1();
		}
        return stack1.pop();
    }

    public int top() {
        if (stack1.empty() == true) {
			this.stack2ToStack1();
		}
        return stack1.peek();
    }*/
    
    /*public Queues() {
       // do initialization if necessary
       stack1 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        stack2 = new Stack<Integer>();
        for (int i = 0; i < stack1.size(); i++){
            stack2.push(stack1.pop());
        }
        int val = stack2.pop();
        for (int i = 0; i < stack2.size(); i++){
            stack1.push(stack2.pop());
        }
        return val;
    }

    public int top() {
    	// write your code here
        stack2 = new Stack<Integer>();
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int val = stack2.peek();
        for (int i = 0; i < stack2.size(); i++){
            stack1.push(stack2.pop());
        }
        return val;
    }*/
}

