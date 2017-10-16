package org.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Course_Schedule_II {
	public static void main(String[] args) {
		Course_Schedule_II cs = new Course_Schedule_II();
		cs.findOrder(2, new int[][]{{1,0}});
	}
	
	/*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        if (prerequisites == null || prerequisites.length == 0 ||
            prerequisites[0].length == 0)
                return new int[]{};
        
        //1. get all course node
        List<CourseNode> nodes = getNodes(numCourses, prerequisites);
        
        //2. get all node with 0 degree
        Queue<CourseNode> q = new LinkedList<CourseNode>();
        for (CourseNode n : nodes){
            if (n.degree == 0){
                q.add(n);
            }
        }
        
        //3. from 0 degree node, begin to loop all neighbors
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        while (!q.isEmpty()){
            CourseNode head = q.poll();
            list.add(head.val);
            for (CourseNode nei : head.neighbors){
            	if (nei.degree > 1)
            		nei.degree -= 1;
            	else
            		nei.degree = 0;
                if (nei.degree  == 0 && set.add(nei.val)){
                    q.add(nei);
                }
            }
        }
        
        //4. change list to int[]
        int[] res = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    
    private List<CourseNode> getNodes(int numCourses, int[][] prerequisites){
        List<CourseNode> list = new ArrayList<CourseNode>();
        Map<Integer, CourseNode> mapNode = new HashMap<Integer, CourseNode>();
        for (int i = 0; i < numCourses; i++){
            CourseNode node = new CourseNode(i);
            list.add(node);
            mapNode.put(i, node);
        }
        
        for (int row = 0; row < prerequisites.length; row++){
            int[] data = prerequisites[row];
            int x = data[0];
            int y = data[1];
            CourseNode nodeX = mapNode.get(x);
            nodeX.degree += 1;
            
            CourseNode nodeY = mapNode.get(y);
            nodeY.neighbors.add(nodeX);
        }
        
        return list;
    }
    
    class CourseNode{
        int val;
        int degree = 0;
        List<CourseNode> neighbors;
        public CourseNode(int x){
            val = x;
            neighbors = new ArrayList<CourseNode>();
        }
    }
}
