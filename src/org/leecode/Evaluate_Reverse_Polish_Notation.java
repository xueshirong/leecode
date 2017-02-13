package org.leecode;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
	//典型的stack问题。逐一扫描每个token，如果是数字，则push入stack，如果是运算符，则从stack中pop出两个数字，进行运算，将结果push回stack。
	//最后留在stack里的数即为最终结果。
	public int evalRPN(String[] tokens) {
        //corner case;
        if (tokens == null || tokens.length == 0)
            return -1;
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++){
            if (tokens[i] == "+" && s.size() > 1){
                int n1 = Integer.valueOf(s.pop());
                int n2 = Integer.valueOf(s.pop());
                s.add(n2 + n1);
                
            }else if (tokens[i] == "-" && s.size() > 1){
                int n1 = Integer.valueOf(s.pop());
                int n2 = Integer.valueOf(s.pop());
                s.add(n2 - n1);
                
            }else if (tokens[i] == "*" && s.size() > 1){
                int n1 = Integer.valueOf(s.pop());
                int n2 = Integer.valueOf(s.pop());
                s.add(n2 * n1);
                
            }else if (tokens[i] == "/" && s.size() > 1){
                int n1 = Integer.valueOf(s.pop());
                int n2 = Integer.valueOf(s.pop());
                s.add(n2 / n1);
            }else{
                s.add(Integer.valueOf(tokens[i]));
            }
        }
        if (s.size() > 1)
            return -1;
        return s.pop();
    }
	
	//from jiu zhang
    public int evalRPN1(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        String operators = "+-*/";
        for(String token : tokens){
            if(!operators.contains(token)){
                s.push(Integer.valueOf(token));
                continue;
            }

            int a = s.pop();
            int b = s.pop();
            if(token.equals("+")) {
                s.push(b + a);
            } else if(token.equals("-")) {
                s.push(b - a);
            } else if(token.equals("*")) {
                s.push(b * a);
            } else {
                s.push(b / a);
            }
        }
        return s.pop();
    }
}
