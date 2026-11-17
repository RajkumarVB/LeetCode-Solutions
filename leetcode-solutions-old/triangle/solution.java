class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] next = new int[m]; 
        int [] curr = new int[m];
        
        for(int j=0; j<m; j++){
            next[j] = triangle.get(m-1).get(j); 
        }
        for(int i=m-2; i>=0 ; i--){
            for(int j=0; j<=i; j++){
                int path1 = triangle.get(i).get(j) + next[j];
                int path2 = triangle.get(i).get(j) + next[j+1];
                curr[j] = Math.min(path1, path2); 
            }
            next = curr; 
        }

        return next[0]; 
    }
}