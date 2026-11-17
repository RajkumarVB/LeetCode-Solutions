class Solution {
    private String s;
    HashMap<Pair<Integer,Integer>, Integer> memoMap = new HashMap<>(); 
    
    public int maxLengthBetweenEqualCharacters(String s) {
        this.s = s; 
        int n = s.length(); 
        return solve(0,n-1); 
    }

    public int solve(int i, int j){
        if(i ==j) return -1; 
        
        if(s.charAt(i) == s.charAt(j)){
            return (j - i -1); 
        }
        Pair p = new Pair(i,j);
        if(memoMap.containsKey(p)) return memoMap.get(p); 

        int tempAns1 = solve(i+1, j);
        int tempAns2 = solve(i, j-1);

        int result = Math.max(tempAns1, tempAns2); 
        memoMap.put(p,result);
        return result; 
    }

}