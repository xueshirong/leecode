package org.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//From Bloomburg : http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=269881&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
//股票价格更新 给定［IBM, 100］［Google 102]［IBM，106］[ Apple 100] 这样一串信息，
//对于一个具体的公司找出最近的价格并输出 问用什么数据结构，为啥，然后比较这个结构的优点啥的 。 
//然后还是这个题，问如何找到 最近更新价格的10个公司，用啥数据结构，具体说说怎么实现的，时间复杂度。 
class ListNode1{
    String val;
    ListNode1 pre;
    ListNode1 next;
    public ListNode1(String v){
        val = v;
        pre = null;
        next = null;
    }
}
class LRU{
    int capacity = 0;
    Map<String, List<Integer>> mapprice = new HashMap<String, List<Integer>>();
    Map<String, ListNode1> mapnode = new HashMap<String, ListNode1>();
    ListNode1 head = new ListNode1("0");
    ListNode1 tail = new ListNode1("-1");
    public LRU(){
        //capacity = c;
        head.next = tail;
        tail.pre = head;
    }
    
    public void put(String key, int val){
        if (mapprice.containsKey(key)){
            mapprice.get(key).add(val);
        }else{
            List<Integer> list = new ArrayList<Integer>();
            list.add(val);
            mapprice.put(key, list);
        }
        
        ListNode1 curr = null;
        if (mapnode.containsKey(key)){
            curr = mapnode.get(key);
            curr.pre.next = curr.next;
            curr.next.pre = curr.pre;
        }else{
            curr = new ListNode1(key);
        }
        mapnode.put(key, curr);
        movenode2tail(curr);
    }

    public int get(String key){
        if (mapprice.containsKey(key)){
            List<Integer> list = mapprice.get(key);
            return list.get(list.size() - 1);
        }
        return -1;
    }
    
    public List<String> getlastN(int n){
    	ListNode1 temp = tail;
        List<String> list = new ArrayList<String>();
        while(temp.pre.val != "0" && n > 0){
        	list.add(temp.pre.val);
            n--;
            temp = temp.pre;
        }
        return list;
    }
    
    private void movenode2tail(ListNode1 node){
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }
}

public class aaatest {
	public static void main(String[] agrs){
		LRU lru = new LRU();
		lru.put("IBM", 100);
		lru.put("Google", 102);
		lru.put("IBM", 106);
		lru.put("Apple", 100);
        /*LRU.put("FB", 110);
        LRU.put("BB", 120);
        LRU.put("FB", 130);
        LRU.put("Google", 150);*/
        //int price = LRU.get("IBM");
        //System.out.println(price);
        List<String> list = lru.getlastN(4);
        System.out.println(list);
    }
}
