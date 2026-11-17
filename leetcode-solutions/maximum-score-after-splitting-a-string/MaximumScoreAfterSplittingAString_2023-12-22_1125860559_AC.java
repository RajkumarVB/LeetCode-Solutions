class Solution {
    public int maxScore(String s) {
        int n = s.length(); 
        int result  =0 , leftScore =0; 
        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == '0') leftScore++; 
            int rightScore = 0; 
            for(int j=i+1; j<n; j++){
                if(s.charAt(j) == '1') rightScore ++; 
            }
            result = Math.max(leftScore + rightScore, result); 
        }
        return result; 
    }
}