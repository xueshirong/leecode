package org.leecode;

import org.leecode.Common.ListNode;

public class Palindrome_Linked_List {
	public boolean isPalindrome(ListNode head) {
        StringBuffer sb = new StringBuffer();
        while(head != null){
            sb.append(head.val);
            head = head.next;
        }
        if (sb.equals(""))
            return false;
        int half = sb.length()/2;
        if (sb.length()%2 == 1)
            half = sb.length()/2 + 1;
        
        for(int i = 0; i< half; i++){
            if (sb.charAt(i) != sb.charAt(sb.length()  -1))
                return false;
        }
        return true;
    }
}
