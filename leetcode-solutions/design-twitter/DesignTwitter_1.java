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
 * Approach:    K-way merge with max-heap (lazy, push next tweet)
 * Complexity:  time O(f + 10 log f) per feed, space O(users + tweets)
 * Also see:    _2: Push all candidate tweets into a size-10 min-heap
 * Submitted:   2026-01-21 (submission 1891415313, AC)
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
        if(posts != null && index < posts.size()){
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