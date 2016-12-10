package org.leecode;

import org.leecode.Common.ListNode;

public class Rehashing {
	//The size of the hash table is not determinate at the very beginning. 
	//If the total size of keys is too large (e.g. size >= capacity / 10), 
	//we should double the size of the hash table and rehash every keys.
	/**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
	public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0)
            return hashTable;
        
        int capacity = 2 *  hashTable.length;
        ListNode[] ht = new ListNode[capacity];
        
        for (ListNode node : hashTable){//rehash
            while (node != null){
                int index = (node.val % capacity + capacity) % capacity;//cal new index
                ht = add2Table(ht, index, node.val);//add to new table
                node = node.next;
            }
        }
        return ht;
    }
    private ListNode[] add2Table(ListNode[] ht, int index, int val){
        if ( ht[index] == null){
        	ht[index] =  new ListNode(val);
        }else{
            ListNode pre = ht[index];
            while (pre.next != null){
            	pre = pre.next;
            }
            pre.next = new ListNode(val);
        }
        return ht;
    }
}
