package org.leecode;

import org.leecode.Common.ListNode;

public class Intersection_of_Two_Linked_Lists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //corner case
        if (headA == null || headB == null)
            return null;
        //check if there is an intersection. if the tails are equal, yes
        ListNode n1 = headA;
        ListNode n2 = headB;
        int len1 = 0, len2 = 0;
        while(n1.next != null){
            n1 = n1.next;
            len1++;
        }
        while(n2.next != null){
            n2 = n2.next;
            len2++;
        }
        if (n1 != n2)
            return null;
        //get intersection. the node with longer path go first.
        if (len1 > len2){//key point: use old head node
            for (int i = 0; i < len1 - len2; i++)
                headA = headA.next;
        }else{
            for (int i = 0; i < len2 - len1; i++)
                headB = headB.next; 
        }
        while (headA != null){
            if (headA.val == headB.val)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
