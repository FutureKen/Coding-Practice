// Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
//
//
//
// postTweet(userId, tweetId): Compose a new tweet.
// getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
// follow(followerId, followeeId): Follower follows a followee.
// unfollow(followerId, followeeId): Follower unfollows a followee.
//
//
//
// Example:
//
// Twitter twitter = new Twitter();
//
// // User 1 posts a new tweet (id = 5).
// twitter.postTweet(1, 5);
//
// // User 1's news feed should return a list with 1 tweet id -> [5].
// twitter.getNewsFeed(1);
//
// // User 1 follows user 2.
// twitter.follow(1, 2);
//
// // User 2 posts a new tweet (id = 6).
// twitter.postTweet(2, 6);
//
// // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
// twitter.getNewsFeed(1);
//
// // User 1 unfollows user 2.
// twitter.unfollow(1, 2);
//
// // User 1's news feed should return a list with 1 tweet id -> [5],
// // since user 1 is no longer following user 2.
// twitter.getNewsFeed(1);


public class Twitter {

    private int timestamp = 0;
    private Map<Integer, User> usermap;

    private class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timestamp++;
            next = null;
        }

    }

    public class User {
        public int id;
        public Set<Integer> followed;
        public Tweet tweethead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); //Follow user self;
            tweethead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        //Add new tweet to the head of tweet list;
        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweethead;
            tweethead = t;
        }

    }

    /** Initialize your data structure here. */
    public Twitter() {
        usermap = new HashMap<Integer, User>();
    }

    
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!usermap.containsKey(userId)) {
            User newuser = new User(userId);
            usermap.put(userId, newuser);
        }
        usermap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new LinkedList<>();

        //Check if user exist;
        if (!usermap.containsKey(userId)) {
            return result;
        }
        //Put all the tweet heads of followed user into Heap, with the ordering of time;
        Set<Integer> followedUser = usermap.get(userId).followed;
        Queue<Tweet> queue = new PriorityQueue<Tweet>(followedUser.size(), (a,b) -> (b.time - a.time));
        for (int user : followedUser) {
            Tweet t = usermap.get(user).tweethead;
            if (t != null) {
                queue.add(t);
            }
        }
        for (int i = 0; i < 10 && !queue.isEmpty(); i++) {
            Tweet t = queue.poll();
            result.add(t.id);
            if (t.next != null) {
                queue.add(t.next);
            }
        }

        return result;
    }
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

        //check if both follower and followee exist;
        if (!usermap.containsKey(followerId)) {
            User u = new User(followerId);
            usermap.put(followerId, u);
        }
        if (!usermap.containsKey(followeeId)) {
            User u = new User(followeeId);
            usermap.put(followeeId, u);
        }
        usermap.get(followerId).follow(followeeId);

    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!usermap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        usermap.get(followerId).unfollow(followeeId);
    }
    
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
