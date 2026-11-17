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
        int matches = 0; 
        for(int i=0; i<26; i++){
            if(s1Count[i] == s2Count[i]) matches ++; 
        }


        while(right < s2.length()){
            if(matches == 26) return true; 
            char charLeft = s2.charAt(left); 
            char charRight = s2.charAt(right); 
            
            s2Count[charLeft - 'a'] --; 
            if(s2Count[charLeft - 'a'] == s1Count[charLeft - 'a']){
                matches ++; 
            } else if((s2Count[charLeft - 'a'] + 1) == s1Count[charLeft - 'a']){
                // previously it was matching
                matches --; 
            }
            left ++; 


            right ++; 
            if(right < s2.length()){
                charRight = s2.charAt(right); 

                s2Count[s2.charAt(right) - 'a'] ++; 
                if(s2Count[charRight - 'a'] == s1Count[charRight - 'a']){
                    matches ++; 
                } else if((s2Count[charRight - 'a'] -1) == s1Count[charRight - 'a']){
                    // previously it was matching 
                    matches --; 
                }
            } 
        }

        return matches == 26; 
    }
}