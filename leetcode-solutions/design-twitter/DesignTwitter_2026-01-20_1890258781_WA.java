class Twitter {

    // user -> post
    private HashMap<Integer,PriorityQueue<Post>> posts; 
    
    // user -> List of following user
    private HashMap<Integer,Set<Integer>> followingUsers; 
    private int time; 

    public Twitter() {
        this.posts = new HashMap<>();
        this.followingUsers = new HashMap<>();
        this.time = 1; 
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!posts.containsKey(userId)){
            posts.put(userId, new PriorityQueue<>((p1, p2) -> p2.time - p1.time)); 
        }

        posts.get(userId).add(new Post(tweetId, time));
        time +=1; 
    }
    
    public List<Integer> getNewsFeed(int userId) {
        

        PriorityQueue<Post> pq = new PriorityQueue<>((p1, p2) -> p2.time - p1.time);
        int count = 10; 
        
        if(posts.containsKey(userId)){
            pq.addAll(posts.get(userId));
        }
        
        if(followingUsers.containsKey(userId)){
            for(int followingUser : followingUsers.get(userId)){
                if(posts.get(followingUser) != null)
                    pq.addAll(posts.get(followingUser));
            }
        }


        while(pq.size() > 10){
            pq.poll();
        }

        List<Integer> posts = new LinkedList<>();
        while(!pq.isEmpty()){
            Post post = pq.poll();
            posts.add(post.tweetId);
        }
        return posts; 
    }

    
    public void follow(int followerId, int followeeId) {
        if(!followingUsers.containsKey(followerId)){
            followingUsers.put(followerId, new HashSet<>());
        }

        followingUsers.get(followerId).add(followeeId);
        System.out.println(followerId + "user followed " + followeeId + " user");
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followingUsers.containsKey(followerId)){
            return; 
        }
        followingUsers.get(followerId).remove(followeeId);
    }

    record Post(int tweetId, int time){

    }
}
// posts
// 1 -> [5]
// 2 -> [6]

// followingList
// 2 -> [1]


// hashmap (userID -> PQ<TweetID>)
// userId -> [tweetId1, tweetId2...]

// HashMap (userID -> List<UserID> (followers))






/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */