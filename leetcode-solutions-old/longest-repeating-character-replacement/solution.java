class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(); 
        int left = 0, right = 0, result = 0; 
        int maxFrequency  =0 ; // maxFrequency int that particular window 
        int[] frequency = new int[26]; 
        while(right < n){
            char c = s.charAt(right); 
            frequency[c-'A']++; 
            maxFrequency = Math.max(maxFrequency, frequency[c-'A']); 
            int replacementsNeeded = (right - left + 1) - maxFrequency; 
            if((right - left + 1) - maxFrequency > k){
                    frequency[s.charAt(left) - 'A']--; 
                    left ++ ; 
            }
            result = Math.max(result, right - left + 1); 
            right++; 
            
        }
        return result; 
    }
}
