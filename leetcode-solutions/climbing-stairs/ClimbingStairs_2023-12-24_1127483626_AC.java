class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<>(); 
    // Map of nth stair, and it's possible ways to react it
    // n -> no of possible ways

    public int climbStairs(int n) {
        if(n==1 || n ==2) return n;  
        if(!memo.containsKey(n)){
            int ans = climbStairs(n-1) + climbStairs(n-2) ; 
            memo.put(n,ans); 
        }
        return memo.get(n); 
    }
}