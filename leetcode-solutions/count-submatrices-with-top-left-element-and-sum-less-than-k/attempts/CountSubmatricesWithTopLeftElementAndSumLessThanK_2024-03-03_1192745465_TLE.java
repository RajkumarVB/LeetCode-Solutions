class Solution {
    HashMap<Pair,Boolean> validMap = new HashMap<>(); 
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length; 
        int m = grid[0].length;
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                isValid(grid,k,i,j,validMap);
            }
        }
        int result =0; 
        // System.out.println(validMap);
        for(var entry : validMap.entrySet()){
            if(entry.getValue()){
                // System.out.println(entry.getKey().i + " " + entry.getKey().j);
                result ++;  
            } 
        }
        return result; 
    }
    public long isValid(int[][] grid, int k, int i, int j,HashMap<Pair,Boolean> validMap){
        if(i < 0 || j <0) return 0; 
        long sum1 = isValid(grid,k,i-1,j,validMap);
        
        if(sum1==Long.MAX_VALUE ||  sum1 >k){
            validMap.put(new Pair(i,j),false);
            return Long.MAX_VALUE; 
        }
        
        long sum2 = isValid(grid,k,i,j-1,validMap);
        
        if(sum2==Long.MAX_VALUE || sum2 >k){
            validMap.put(new Pair(i,j),false);
            return Long.MAX_VALUE; 
        }
        
        long sum = sum1 + sum2 - sum(grid, i-1,j-1) + grid[i][j]; 
        
        if(sum <= k){
            validMap.put(new Pair(i,j),true);
            return sum; 
        }
        validMap.put(new Pair(i,j),false);
        return Long.MAX_VALUE; 
    }
    public long sum(int[][] grid, int i, int j){
        long sum = 0; 
        for(int row=0; row<=i; row++){
            for(int col=0; col<=j; col++){
                sum += grid[row][col]; 
            }
        }
        return sum; 
    }
    record Pair(int i, int j){
        
    }
}
