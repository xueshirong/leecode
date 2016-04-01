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
}
