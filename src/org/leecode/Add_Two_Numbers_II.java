package org.leecode;

import java.util.Stack;

import org.leecode.Common.ListNode;

public class Add_Two_Numbers_II {
	/*You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.

	Follow up:
	What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
	
	Example:
	Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 8 -> 0 -> 7
	思路： 先把list 翻转， 再相加，在将结果翻转*/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        return reverseList(add(l1, l2));
    }
    
    private ListNode add(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null && l2 != null)
            return l2;
        if (l1 != null && l2 == null)
            return l1;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry = 0;
        while (l1 != null && l2 != null){
            int sum = carry + l1.val + l2.val;
            carry = sum / 10;
            head.next = new ListNode(sum % 10);
            l1 = l1.next; l2 = l2.next; head = head.next;
        }
        while (l1 != null){
            int sum = carry + l1.val;
            carry = sum / 10;
            head.next = new ListNode(sum % 10);
            l1 = l1.next; head = head.next;
        }
        while (l2 != null){
            int sum = carry + l2.val;
            carry = sum / 10;
            head.next = new ListNode(sum % 10);
            l2 = l2.next; head = head.next;
        }
        if (carry != 0)
            head.next = new ListNode(carry);
        return dummy.next;
    }
    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
    
    //..... Solution 2 不用翻转list,用stack存储
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while (l1 != null){//add l1 to s1
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){//add l2 to s2
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        Stack<Integer> s3 = new Stack<Integer>();
        while(!s1.isEmpty() && !s2.isEmpty()){//s3 = s1 +　s2
            int sum = s1.pop() + s2.pop() + carry;
            carry = sum / 10;
            s3.push(sum % 10);
        }
        while (!s1.isEmpty()){
            int sum = s1.pop() + carry;
            carry = sum / 10;
            s3.push(sum % 10);
        }
        while (!s2.isEmpty()){
            int sum = s2.pop() + carry;
            carry = sum / 10;
            s3.push(sum % 10);
        }
        if (carry != 0)// add carry
            s3.push(carry);
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (!s3.isEmpty()){//change s3 to ListNode
            head.next = new ListNode(s3.pop());
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode dummy = new ListNode(-1);
        while(!s1.isEmpty() || !s2.isEmpty()){
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            
            sum = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = dummy.next;
            dummy.next = node;
        }
        if (sum == 1){
            ListNode node = new ListNode(1);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
        
    }

    public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        ListNode l11 = reverse(l1);
        ListNode l22 = reverse(l2);
        ListNode l33 = add(l11, l22);
        ListNode l3 = reverse(l33);
        return l3;
    }
    
    private ListNode add4(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int sum = 0;
        while (l1 != null || l2 != null){
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            } 
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(sum % 10);
            head = head.next;
            sum = sum / 10;
        }
        if (sum == 1)
            head.next = new ListNode(1);
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head){
        ListNode pre = new ListNode(-1);
        while (head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

}
