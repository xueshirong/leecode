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
		  System.out.println("Please input first side:");//�����1����
		  double a = scan.nextDouble();
		  System.out.println("Please input second side:");//�����2����
		  double b = scan.nextDouble();
		  System.out.println("Please input third side:");////�����3����
		  double c = scan.nextDouble();
		   scan.close();
		  
		  Trigon.isTrigon(a, b, c);//�ж�������ܷ񹹳��������Լ�����
	 }
	 
	 public static void isTrigon(double a, double b, double c) {
		  
		 if(a <= 0 || b <=0 || c <= 0){//�����С��0�ı߳�����Ȼ����
			 System.out.println("Can't");
			 return;
		 }

		 if (a + b > c && a + c > b && b + c > a) {//2��֮��һ��Ҫ���ڵ�����
			 if (a == b || a == c || b == c) {//����
				 if (a == b && b == c) {//�ȱ�
					 System.out.println("������ɵȱ�������");
				 } else {
					 System.out.println("������ɵ���������");
				 }
				 return;
			 }

			 System.out.println("���������ͨ������");//��ͨ
			 return;
		  }
		  System.out.println("���ܹ����������!");//���ܹ���������

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
