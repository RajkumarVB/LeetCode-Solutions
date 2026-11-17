class Solution {
    private int[]dp; 
    private int n; 
    public int climbStairs(int n) {
        this.dp = new int[n+1];
        this.n = n; 
        Arrays.fill(dp,-1); 
        return solve(0); 
    }

    public int solve(int start){
        if(start == n || start == n-1) return 1; 
        if(dp[start] != -1) return dp[start]; 
        dp[start] = solve(start+1) + solve(start + 2);
        return dp[start]; 
    }
}

