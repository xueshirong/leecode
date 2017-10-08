package org.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Jiu Zhang
public class Friendship_Service {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Friendship_Service fs = new Friendship_Service();
		fs.follow(1, 3);
		fs.getFollowers(1);
		fs.getFollowings(3);
		fs.follow(2, 3);
		fs.getFollowings(3);
		fs.unfollow(1, 3);
		fs.getFollowings(3);
	}
	
	Map<Integer, Set<Integer>> followers;
    Map<Integer, Set<Integer>> followings;
    public Friendship_Service() {
        // do intialization if necessary
        followers = new HashMap<Integer, Set<Integer>>();
        followings = new HashMap<Integer, Set<Integer>>();
    }

    /*
     * @param user_id: An integer
     * @return: all followers and sort by user_id
     */
    public List<Integer> getFollowers(int user_id) {
        // write your code here
        List<Integer> list = new ArrayList<Integer>();
        if (!followings.containsKey(user_id))
            return list;
        list = new ArrayList<Integer>(followings.get(user_id));
        Collections.sort(list);
        return list;
    }

    /*
     * @param user_id: An integer
     * @return: all followings and sort by user_id
     */
    public List<Integer> getFollowings(int user_id) {
        // write your code here
        List<Integer> list = new ArrayList<Integer>();
        if (!followers.containsKey(user_id))
            return list;
        list = new ArrayList<Integer>(followers.get(user_id));
        Collections.sort(list);
        return list;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        // write your code here
        if (!followings.containsKey(from_user_id))
            followings.put(from_user_id, new HashSet<Integer>());
        Set<Integer> set = followings.get(from_user_id);
        set.add(to_user_id);
        
        if (!followers.containsKey(to_user_id))
            followers.put(to_user_id, new HashSet<Integer>());
        set = followers.get(to_user_id);
        set.add(from_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        // write your code here
        Set<Integer> set;
        if (followings.containsKey(from_user_id)){
            set = followings.get(from_user_id);
            set.remove(to_user_id);
        }
        
        if (followers.containsKey(to_user_id)){
            set = followers.get(to_user_id);
            set.remove(from_user_id);
        }
    }

}
