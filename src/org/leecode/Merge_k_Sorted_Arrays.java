package org.leecode;

import java.util.*;

class Element{
	int val;
	int row;
	int col;
	public Element(int v, int r, int c){
		val = v;
		row = r;
		col = c;
	}
}
public class Merge_k_Sorted_Arrays {
	public int[] mergeKSortedArrays(int[][] arrays){
		if (arrays == null || arrays[0].length == 0)
			return null;
		PriorityQueue<Element> pq = new PriorityQueue<Element>(arrays.length, new Comparator<Element>(){
			public int compare(Element a, Element b){
				return a.val - b.val;
			}
		});
		int totalsize = 0;
		for (int i = 0; i < arrays.length; i++){
			if (arrays[i].length > 0){
				Element e = new Element(arrays[i][0], i, 0);
				pq.add(e);
				totalsize += arrays[i].length;
			}
		}
		
		int[] res = new int[totalsize];
		int index = 0;
		while(!pq.isEmpty()){
			Element e = pq.poll();
			res[index] = e.val;
			index++;
			if (e.col + 1 < arrays[e.row].length){
				pq.add(new Element(arrays[e.row][e.col+1], e.row, e.col + 1));
			}			
		}
		
		return res;
	}
}
