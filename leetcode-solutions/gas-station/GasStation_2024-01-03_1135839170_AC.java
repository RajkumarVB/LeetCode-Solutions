class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        long gasSum = sum(gas);
        long costSum = sum(cost);
        if(costSum > gasSum ) return -1; 
        int n = gas.length; 

        // At this point, we can surely say that, we have a solution.
        long gasLeft =0; 
        int result  = 0; 
        for(int i=0; i<n; i++) {
            gasLeft += gas[i]; 
            gasLeft -= cost[i]; 
            if(gasLeft < 0) {
                // The if will not execute if i == n-1
                // Because gasLeft < 0, then we can't have a solution. 
                // That case we have eliminated before. 
                gasLeft = 0; 
                result = i +1; 
            }
        }
        return result; 
    }
    public long sum(int[] arr){
        int n = arr.length; 
        long sum = 0 ; 
        for(int i=0; i<n; i++){
            sum += arr[i];
        }
        return sum; 
    }
}