class Twitter {

    // user -> post
    private HashMap<Integer,PriorityQueue<Post>> posts; 
    
    // user -> List of following user
    private HashMap<Integer,List<Integer>> followingUsers; 
    private int time; 
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
    }
    
    public void follow(int followerId, int followeeId) {
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        
    }

    record Post(int tweetId, int time){

    }
}

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