package org.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class The_Skyline_Problem {
	/**时间O(NlogN) 空间O(N)
     * https://segmentfault.com/a/1190000003786782
     * 把这些矩形拆成两个点，一个左上顶点，一个右上顶点。将所有顶点按照横坐标排序后，开始遍历这些点。
     遍历时，通过一个大顶堆来得知当前图形的最高位置。堆顶是所有顶点中最高的点，只要这个点没被移出堆，说明这个最高的矩形还没结束。
     对于左顶点，我们将其加入堆中。对于右顶点，我们找出堆中其相应的左顶点，然后移出这个左顶点，同时也意味这这个矩形的结束。
     代码中，为了区分左右顶点，左顶点高度值是负数，而右顶点高度值则存的是正数。
     注意:堆中先加入一个0高度，帮助我们在只有最矮的建筑物时选择最低值
     * @param buildings
     * @return
     */
    
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<>();
		List<int[]> height = new ArrayList<>();

		for (int[] b : buildings) {// 拆解矩形，构建顶点的列表
			height.add(new int[] { b[0], -b[2] });// 左顶点存为负数
			height.add(new int[] { b[1], b[2] });// 右顶点存为正数
		}
		// 根据横坐标对列表排序，相同横坐标的点纵坐标小的排在前面
		Collections.sort(height, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0];
				} else {
					return a[1] - b[1];
				}
			}
		});
		// 构建堆，按照纵坐标来判断大小
		Queue<Integer> pq = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		});
		
		pq.offer(0);// 将地平线值先加入堆中		
		int prev = 0;// prev用于记录上次keypoint的高度
		for (int[] h : height) {			
			if (h[1] < 0) {// 将左顶点加入堆中
				pq.offer(-h[1]);
			} else {// 将右顶点对应的左顶点移去				
				pq.remove(h[1]);
			}
			int cur = pq.peek();			
			if (prev != cur) {// 如果堆的新顶部和上个keypoint高度不一样，则加入一个新的keypoint
				result.add(new int[] { h[0], cur });
				prev = cur;
			}
		}
		return result;
	}
}

