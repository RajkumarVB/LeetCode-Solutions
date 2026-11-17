class Solution {
    public int maxScore(String s) {
        int n = s.length(); 
        int[] rightOnesCount = new int[n]; 
        int rightCount =0 ; 

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '1'){
                rightCount++; 
            }
            rightOnesCount[i] = rightCount; 
        }

        int result  =0 , leftScore =0; 
        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == '0') leftScore++; 
            int rightScore = rightOnesCount[i+1]; 
            result = Math.max(leftScore + rightScore, result); 
        }
        return result; 
    }
}