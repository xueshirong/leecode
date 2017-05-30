package AM;

import java.util.Stack;

public class Baseball_Score {
	public static void main(String[] args) {
		int res = 0;
		res = getScore(new String[]{"5", "-2", "4", "Z", "X", "9", "+", "+"});//27
		System.out.println(res);
		res = getScore(new String[]{"Z", "5", "-2", "4", "Z", "X", "9", "+", "+"});//27
		System.out.println(res);
		res = getScore(new String[]{"+", "5", "-2", "4", "Z", "X", "9", "+", "+"});//27
		System.out.println(res);
		res = getScore(new String[]{"X", "5", "-2", "4", "Z", "X", "9", "+", "+"});//27
		System.out.println(res);
		res = getScore(new String[]{"Z", "+", "X", "5", "-2", "4", "Z", "X", "9", "+", "+"});//27
		System.out.println(res);
		res = getScore(new String[]{"5", "+", "-2", "4", "Z", "X", "9", "+", "+"});//32
		System.out.println(res);
		res = getScore(new String[]{"Z", "+", "X"});//0
		System.out.println(res);
		res = getScore(new String[]{"X", "X", "X"});//0
		System.out.println(res);
		res = getScore(new String[]{"X", "X", "a"});//-1
		System.out.println(res);
	}

	private static int getScore(String[] str) {
		int sum = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (String s : str){
			if (tryParseInteger(s)){//digit
				int val = Integer.parseInt(s);
				stack.add(val);
				sum += val;
				continue;
			}
			switch(s){//character
				case "X":
					int val = 0;
					if (stack.size() > 0)
						val = 2 * stack.peek();
					sum += val;
					stack.add(val);
					break;
				case "Z":
					if (stack.size() > 0)
						sum -= stack.pop();
					break;
				case "+":
					int val1 = 0;
					if (stack.size() > 0)
						val1 = stack.pop();
					int val2 = 0;
					if (stack.size() > 0)				
						val2 = stack.pop();
					
					int val3 = val1 + val2;
					sum += val3;
					stack.add(val2);
					stack.add(val1);
					stack.add(val3);										
					break;
				default://invalid character
					return -1;
			}			
		}		
		return sum;
	}

	//try to parse string to integer
	private static boolean tryParseInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}	
}
