package org.leecode;

import java.util.ArrayList;

import org.leecode.Common.ListNode;

public class Palindrome_Linked_List {
	public boolean isPalindrome(ListNode head) {
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        while(head != null){
            al.add(head.val);
            head = head.next;
        }
        if (al.size() == 0)
            return false;
        int half = al.size()/2;
        if (al.size()%2 == 1)
            half = al.size()/2 + 1;
        
        for(int i = 0; i< half; i++){
            if (!al.get(i).equals(al.get(al.size() - 1 - i)))
                return false;
        }
        return true;
	}
	public boolean isPalindrome2(ListNode head) {
        if (head == null)
            return true;
        ListNode mid = findMiddle(head);
        mid.next = reverseList(mid.next);
        ListNode p1 = head;
        ListNode p2 = mid.next;
        while(p1 != null && p2 != null && p1.val == p2.val){
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p2 == null)
            return true;
        return false;
    }
    
    //find the midNode in a list
    public ListNode findMiddle(ListNode head){
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
