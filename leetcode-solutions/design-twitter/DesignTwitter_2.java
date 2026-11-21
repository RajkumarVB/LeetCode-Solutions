/*
 * 355. Design Twitter  [Medium]
 * https://leetcode.com/problems/design-twitter/
 * Topics: Hash Table, Linked List, Design, Heap (Priority Queue)
 *
 * Problem:     Design a mini Twitter: postTweet, follow, unfollow, and getNewsFeed
 *              returning the 10 most recent tweets from the user and the people they
 *              follow.
 * Example:     post(1,5); feed(1)=[5]; follow(1,2); post(2,6); feed(1)=[6,5]
 * Constraints: <= 3e4 calls
 *
 * Key idea:    Store each user's tweets newest-first with a global timestamp. For the feed,
 *              merge k sorted lists with a max-heap: push each followee's newest tweet, pop
 *              and push that user's next tweet, 10 times.
 *
 * Approach:    Push all candidate tweets into a size-10 min-heap
 * Complexity:  time O(T log 10) per feed, space O(users + tweets)
 * Also see:    _1: K-way merge with max-heap (lazy, push next tweet)
 * Submitted:   2026-01-20 (submission 1891367597, AC)
 */

class Twitter {

    // userId -> following users
    private HashMap<Integer, Set<Integer>> followMap; 

    // userId -> posted tweets
    private HashMap<Integer, LinkedList<Tweet>> postsMap; 

    private long time; 

    public Twitter() {
        followMap = new HashMap<>();
        postsMap = new HashMap<>();
        time = 0; 
    }
    
    public void postTweet(int userId, int tweetId) {
        time ++; 

        postsMap.computeIfAbsent(userId, (u -> new LinkedList<>())); 
        postsMap.get(userId).addFirst(new Tweet(tweetId, time)); 
        // keeping recent tweet near the head; 


    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        // min heap -> poll always returns the earliest tweet
        PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> Long.compare(t1.timestamp, t2.timestamp));

        List<Tweet> selfPosts = postsMap.get(userId);
        if(selfPosts != null){
            pq.addAll(selfPosts);
        }

        if(followMap.get(userId) != null){
            for(int followingUser : followMap.get(userId)){
                if(postsMap.get(followingUser) != null){
                    for(Tweet t : postsMap.get(followingUser)){
                        pq.add(t);
                        if(pq.size() > 10){
                            pq.poll();
                        }
                    }
                }
            }
        }

        while(pq.size() > 10) pq.poll(); 

        List<Integer> feed = new LinkedList<>();
        while(!pq.isEmpty()){
            feed.add(pq.poll().tweetId);
        }

        Collections.reverse(feed);
        return feed; 
    }
    

    // 1,2
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, (k -> new HashSet<>())); 
        followMap.get(followerId).add(followeeId); 

    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }


    record Tweet(int tweetId, long timestamp){}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */