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

        // only keeping 10 tweets/posts for a user
        if(postsMap.get(userId).size() > 10){
            postsMap.get(userId).removeLast(); 
        }
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