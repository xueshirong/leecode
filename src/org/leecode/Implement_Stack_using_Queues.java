package org.leecode;

import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_using_Queues {
Queue<Integer> in = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        in.add(x);
        for(int i = 1; i < in.size(); i ++){
            in.add(in.poll());
        }
    }

    // Removes the element on top of the stack.
    void pop() {
        in.poll();
    }

    // Get the top element.
    int top() {
        return in.peek();
    }

    // Return whether the stack is empty.
    boolean empty() {
        return in.isEmpty();
    }
}
