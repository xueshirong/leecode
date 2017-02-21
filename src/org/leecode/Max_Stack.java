package org.leecode;

import java.util.Stack;

//Design a stack with push(), pop() and max() in O(1) time.
//实现MaxStack(), 其中实现PeekMax(), PopMax(), 要求O(1)。 

//Tag: LinkedIn

//Solution:
//在push的时候记录当前的最大值十分显然，只需要在插入当前值的时候比较是否比现在的最大值大，如果是，更新最大值即可。
//问题在于如何恰当处理pop的情况：直观想法是，当需要出栈的元素是当前最大值，则需要“回溯”到前一个最大值。
//考虑到栈具有LIFO的特性，那么与之匹配地，最大值追踪方式也需要具有相同特性：不妨用另一个栈追踪最大值。
//注意一个细节，当最大值重复入栈时，我们的“最大值栈”也需要重复记录该值。
//否则，在弹出第一个重复最大值的时候，我们就可能在最大值栈中丢失相应的信息。
public class Max_Stack {
	private Stack<Integer> valueStack;
    private Stack<Integer> maxStack;
    
    public void push(int value){
        valueStack.push(value);
        if (maxStack.isEmpty() || value > maxStack.peek()){
            maxStack.push(value);
        }
    }
    
    public void popMax(){
        int value = valueStack.peek();
        valueStack.pop();
        if (value == maxStack.peek()){
            maxStack.pop();
        }
    }
    
    public int peekMax(){
        return maxStack.peek();
    }
}
