class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false; 
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        for(int k = 0; k < s1.length(); k++){
            char c1 = s1.charAt(k);
            char c2 = s2.charAt(k);

            s1Count[c1 - 'a']++; 
            s2Count[c2 - 'a']++; 
        }

        int windowStart = 0; 
        for(int windowEnd = s1.length(); windowEnd < s2.length(); windowEnd ++){
            if(windowContainsSameCharacters(s1Count, s2Count)) return true; 
            int windowStartCharIdx = s2.charAt(windowStart) - 'a'; 
            s2Count[windowStartCharIdx] --; 
            windowStart ++; 
            int windowEndCharIdx = s2.charAt(windowEnd) - 'a'; 
            s2Count[windowEndCharIdx] ++; 
        }

        return windowContainsSameCharacters(s1Count, s2Count); 
    }
    private boolean windowContainsSameCharacters(int[] s1Count,  int[] s2Count){
        for(int i=0; i<s1Count.length; i++){
            if(s1Count[i] != s2Count[i]) return false; 
        }
        return true; 
    }
}