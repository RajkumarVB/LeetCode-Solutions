class Solution {
    private String s;
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
        int tempAns1 = solve(i+1, j);
        int tempAns2 = solve(i, j-1);
        return Math.max(tempAns1,tempAns2); 
    }
}