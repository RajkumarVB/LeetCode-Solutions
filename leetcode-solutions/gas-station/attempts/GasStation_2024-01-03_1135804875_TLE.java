class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length; 
        
        for(int i=0; i<n; i++){
            int j = i ;
            int gasLeft =0; 
            boolean canGo = true; 
            do{
                gasLeft += gas[j]; 
                if(gasLeft < cost[j]){
                    canGo = false; 
                    break; 
                }
                gasLeft -= cost[j]; 
                j = (j+1) % n; 
            }while((j != i)); 
            if(canGo) return i; 
        }
        return -1; 
    }
}