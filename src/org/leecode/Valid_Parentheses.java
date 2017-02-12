package org.leecode;

import java.util.Stack;

public class Valid_Parentheses {
	//From Jiu Zhang
	public boolean isValid(String s) {
        if(s == "")
            return false;
        String target = "([{";
        Stack<Character> stack = new Stack<Character>();
        for(Character c: s.toCharArray()){
            if (target.contains(String.valueOf(c)))//if c is left Parentheses
                stack.push(c);//add c to stack
            else{//if c is right Parentheses, check the peek is pair with c or not
                if (!stack.isEmpty() && isPair(stack.peek(), c))//if c's pair is in the stack peek, then pop the pair
                    stack.pop();
                else
                    return false;
            }
        }//finally, if string is valid, the stack should be empty
        return stack.isEmpty();
    }
    //check c1 and c2 is pair or not
    private boolean isPair(Character c1, Character c2){
        if ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}'))
            return true;
        return false;
    }
    
    //solution 2
    public boolean isValid2(String s) {
        //corner case
        if (s == null || s.equals(""))
            return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.add(c);
            }else if (!stack.isEmpty() && isPair(stack.peek(), c)){
                stack.pop();
            }else
                return false;
        }
        return stack.isEmpty();
    }
}
