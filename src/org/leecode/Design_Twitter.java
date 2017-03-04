package org.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Design_Twitter {
	class Tweet{//自定义类，用于存储tweet id 和时间
        int id;
        int time;
        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
        }
    }
    //Set，可以避免重复id的判断处理
    private Map<Integer, HashSet<Tweet>> mapUserTweet;//map user and tweet id. set中存储各自发表的文章
    private Map<Integer, HashSet<Integer>> mapUserFollow;// map user and followee id. List中存储各自的关注的好友id
    int cnt = 0;
    
    /** Initialize your data structure here. */
    public Design_Twitter() {
        mapUserTweet = new HashMap<Integer, HashSet<Tweet>>();
        mapUserFollow = new HashMap<Integer, HashSet<Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        //tweets
        if (!mapUserTweet.containsKey(userId)){
            mapUserTweet.put(userId, new HashSet<Tweet>());
        }
        mapUserTweet.get(userId).add(new Tweet(tweetId, cnt++));
        
        //add itself to follow
        follow(userId, userId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        if (!mapUserFollow.containsKey(userId)) return res;
        
        Set<Integer> followeeList = mapUserFollow.get(userId);//用户的好友列表
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>((t1, t2) -> t2.time - t1.time);
        for (int i = 0 && i < 10 int fid : followeeList){//循环每个好友
            Set<Tweet> set = mapUserTweet.get(fid);
            if (set == null)  continue;//用户没有发表过tweet
            for (Tweet t : set){//每个好友发表的前10个tweet，加入到res
                pq.add(t);
            }
        } 
        while (pq.size() > 0 && res.size() < 10){
            res.add(pq.poll().id);
        }
        
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> set = new HashSet<Integer>();
        if(mapUserFollow.containsKey(followerId)){
            set = mapUserFollow.get(followerId);
        }
        set.add(followeeId);
        mapUserFollow.put(followerId, set);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!mapUserFollow.containsKey(followerId)){//用户没有关注任何人，直接返回
            return;
        }else if (followerId == followeeId){//不能把自己unfollow
            return;
        }else{
            HashSet<Integer> list = mapUserFollow.get(followerId);
            if (!list.contains(followeeId)){//用户关注的好友中，没有找到该id
                return;
            }else{
                list.remove(new Integer(followeeId));//不能直接remove id, 否则会按照list的index去删除，而不是删除对象。
                mapUserFollow.put(followerId, list);
            }
        }
    }
}
