class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int maxFuelPoint = -1; 
        int n = gas.length; 

        int maxGas = Integer.MIN_VALUE; 
        for(int i=0; i<n; i++){
            if((gas[i] - cost[i]) >= 0 && (gas[i] - cost[i]) > maxGas) {
                maxGas = gas[i] - cost[i]; 
                maxFuelPoint = i; 
            }
        }
        if(maxFuelPoint  == -1) return -1; 


        boolean canGo = false; 
        int gasLeft = 0; 
        int i = maxFuelPoint; 
        do{
            gasLeft += gas[i]; 
            if(cost[i] > gasLeft) return -1; 
            gasLeft -= cost[i]; 
            i = (i+1) % n; 
        }while(i != maxFuelPoint); 
        return maxFuelPoint; 
    }
}