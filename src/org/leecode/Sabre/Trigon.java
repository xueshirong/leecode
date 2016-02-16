package org.leecode.Sabre;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Trigon {
	private double a;
	private double b;
	private double c;
	
	 public Trigon(double a, double b, double c) {
		  this.a = a;
		  this.b = b;
		  this.c = c;
	 }
	 
	 public static void main(String[] args) {
		  
		  Scanner scan = new Scanner(System.in);
		  System.out.println("Please input first side:");//输入第1条边
		  double a = scan.nextDouble();
		  System.out.println("Please input second side:");//输入第2条边
		  double b = scan.nextDouble();
		  System.out.println("Please input third side:");////输入第3条边
		  double c = scan.nextDouble();
		   scan.close();
		  
		  Trigon.isTrigon(a, b, c);//判断输入的能否构成三角形以及类型
	 }
	 
	 public static void isTrigon(double a, double b, double c) {
		  
		 if(a <= 0 || b <=0 || c <= 0){//如果有小于0的边长，显然不行
			 System.out.println("Can't");
			 return;
		 }

		 if (a + b > c && a + c > b && b + c > a) {//2边之和一定要大于第三边
			 if (a == b || a == c || b == c) {//等腰
				 if (a == b && b == c) {//等边
					 System.out.println("可以组成等边三角形");
				 } else {
					 System.out.println("可以组成等腰三角形");
				 }
				 return;
			 }

			 System.out.println("可以组成普通三角形");//普通
			 return;
		  }
		  System.out.println("不能够组成三角形!");//不能构成三角形

	 }
	 
	 public static boolean isValid(String s) {
		 HashMap<Character, Character> map = new HashMap<Character, Character>();
		 map.put('(', ')');
		 map.put('[', ']');
		 map.put('{', '}');
		 
		 Stack<Character> stack = new Stack<Character>();
		 
		 for (int i = 0; i < s.length(); i++) {
			 char curr = s.charAt(i);
		 
			 if (map.keySet().contains(curr)) {
				 stack.push(curr);
			 } else if (map.values().contains(curr)) {
				 if (!stack.empty() && map.get(stack.peek()) == curr) {
					 stack.pop();
				 } else {
					 return false;
				}
			}
		}
		 
		return stack.empty();
	}
}
