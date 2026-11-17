class Solution {
    private int m, n; 
    HashMap<Pair<Integer,Integer>, Integer> memoMap = new HashMap<>(); 
    public int uniquePaths(int m, int n) {
        this.m =m; 
        this.n =n; 
        return backtrack(0,0); 
    }
    public int backtrack(int i, int j){
        if(i == m-1 || j ==n-1) return 1; 
        Pair p = new Pair(i,j); 
        if(memoMap.containsKey(p)){
            return memoMap.get(p); 
        }
        
        int tempAns1 = 0, tempAns2 = 0; 
        tempAns1 = backtrack(i+1,j);
        tempAns2 = backtrack(i,j+1);
        
        int result = tempAns1 + tempAns2;

        memoMap.put(p,result);
        return tempAns1 + tempAns2; 
    }
}