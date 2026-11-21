class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(); 
        int result = 0; 
        for(int i=0; i<n; i++){
            int[] frequency = new int[26]; 
            int maxFrequency = 0; 
            for(int j=i; j<n; j++){
                char c = s.charAt(j) ; 
                frequency[c-'A'] ++; 
                maxFrequency = Math.max(frequency[c-'A'], maxFrequency); 

                int replacementsNeeded = (j-i+1) - maxFrequency; 
                if(replacementsNeeded <= k){
                    result = Math.max(result, j-i+1); 
                }
                else{
                    break; 
                } 
            }
        }
        return result; 
    }
}