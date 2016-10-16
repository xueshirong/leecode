package org.leecode;

import java.util.HashMap;
import java.util.Map;

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
	//From Jiu Zhang
	public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null)
            return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode newhead;
        while (head != null){
            if (map.containsKey(head)){
                newhead = map.get(head);
            }else{
                newhead = new RandomListNode(head.label);
                pre.next = newhead;
                map.put(head, newhead);
            }
            pre.next = newhead;
            
            if (head.random != null){
                if (map.containsKey(head.random)){
                    newhead.random = map.get(head.random);
                }else{
                    newhead.random = new RandomListNode(head.random.label);
                    map.put(head.random, newhead.random);
                }
            }
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }
}
