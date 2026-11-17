class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false; 
        // consider all the windows of s1.length in s2 and check if all the characters in s1 is there in that window. 
        int windowLength = s1.length(); 
        int left = 0, right = windowLength -1; 

        HashSet<Character> set = new HashSet<>();
        for(char c : s1.toCharArray()){
            set.add(c); 
        }

        // HashSet<Character> windowCharSet = new HashSet<>();
        // for(int i=left; i<=right; i++) windowCharSet.add(s2.charAt(i)); 

        for(; right< s2.length(); right++, left ++){
            boolean isAllCharPresent = true; 
            for(int i=left; i<=right;i++){
                char c = s2.charAt(i); 
                if(!set.contains(c)){
                    isAllCharPresent = false; 
                    break; 
                }
            }
            if(isAllCharPresent) return true; 
        }

        return false; 
    }
}

// ab, ba

// eidbaooo
