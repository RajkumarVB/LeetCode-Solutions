class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false; 
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        int left =0, right = 0; 
        for(; right < s1.length(); right++){
            char c1 = s1.charAt(right);
            char c2 = s2.charAt(right);

            s1Count[c1 - 'a']++; 
            s2Count[c2 - 'a']++; 
        }
        right --; 
        while(right < s2.length()){
            if(windowContainsSameCharacters(s1Count, s2Count)) return true; 
            s2Count[s2.charAt(left) - 'a'] --; 
            left ++; 
            right ++; 
            if(right < s2.length()) s2Count[s2.charAt(right) - 'a'] ++; 
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