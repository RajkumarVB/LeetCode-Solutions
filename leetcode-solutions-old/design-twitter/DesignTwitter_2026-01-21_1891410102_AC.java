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
        
        // max heap -> poll always returns the recent tweet
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Long.compare(n2.tweet().timestamp(), n1.tweet().timestamp()));
        
        addPostToPQ(pq, userId, 0);

        for(int followingUser : followMap.getOrDefault(userId, Set.of())){
            addPostToPQ(pq, followingUser, 0);
            if(pq.size() > 10){
                pq.poll();
            }
        }


        List<Integer> feed = new LinkedList<>();

        while(!pq.isEmpty() && feed.size() < 10){
            Node node = pq.poll(); 
            feed.add(node.tweet().tweetId());
            addPostToPQ(pq,node.userId, node.index + 1);
        }

        return feed; 
    }


    private void addPostToPQ(PriorityQueue<Node> pq, int userId, int index){
        List<Tweet> posts = postsMap.get(userId);
        if(posts != null && posts.size() > index){
            Tweet post = posts.get(index);
            pq.add(new Node(post, userId, index));
        }
    }
    
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

    record Node(Tweet tweet, int userId, int index){}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */