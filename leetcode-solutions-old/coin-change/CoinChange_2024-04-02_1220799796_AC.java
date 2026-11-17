class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        

        int[] prev = new int[amount+1];
        
        for(int am =0; am <= amount; am++){
            if(am % coins[0] == 0) prev[am] = am / coins[0];
            else prev[am] = (int) Math.pow(10,9); 
        }

        for(int i=1; i<n; i++){
            int[] curr = new int[amount+1];
            for(int am =0; am <= amount; am++){
                
                int notTake = prev[am]; 
                int take = (int) Math.pow(10,9); 
                if(am >= coins[i]){
                    take = 1 + curr[am-coins[i]]; 
                }
                curr[am] = Math.min(notTake, take);
            }
            prev = curr; 
        }

        if(prev[amount] >= Math.pow(10,9)) return -1; 
        return prev[amount]; 
    }
}