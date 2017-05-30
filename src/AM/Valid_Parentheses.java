package AM;

import java.util.Stack;

public class Valid_Parentheses {
	public static void main(String[] args) {
		boolean res = isValid("()[,]{}");//false, invalid char
		System.out.println(res);		
		res = isValid("()[]{}");//true
		System.out.println(res);
	}

	//check the input string is valid parentheses
	public static boolean isValid(String str) {
        //corner case
        if (str == null || str.equals(""))
            return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.add(c);
            }else if (!stack.isEmpty() && isPair(stack.peek(), c)){
                stack.pop();
            }else
                return false;
        }
        return stack.isEmpty();
    }
	
	//check c1 and c2 is pair or not
    private static boolean isPair(Character c1, Character c2){
        if ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}'))
            return true;
        return false;
    }
}
