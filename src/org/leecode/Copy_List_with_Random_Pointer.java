package org.leecode;

import java.util.HashMap;

import org.leecode.Common.RandomListNode;

public class Copy_List_with_Random_Pointer {
	public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head;
        RandomListNode empty = new RandomListNode(0);
        RandomListNode pre = empty;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        while(head != null){//create new list without random point. save old node and new node to map. 
            RandomListNode node = new RandomListNode(head.label);
            map.put(head, node);
            pre.next = node;
            pre = pre.next;
            head = head.next;
        }
        pre = empty.next;
        head = cur;
        while(head != null){
            pre.random = map.get(head.random);
            head = head.next;
            pre =  pre.next;
        }        
        return empty.next;
    }
}
