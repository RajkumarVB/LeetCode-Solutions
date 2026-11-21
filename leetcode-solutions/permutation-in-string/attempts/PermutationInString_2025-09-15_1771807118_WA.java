class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false; 
        // consider all the windows of s1.length in s2 and check if all the characters in s1 is there in that window. 
        int windowLength = s1.length(); 
        int left = 0, right = 0; 

       
        HashSet<Character> windowCharSet = new HashSet<>();
        for(; right < windowLength; right++){
            windowCharSet.add(s2.charAt(right)); 
        }
        right --; 
        

        while(right < s2.length()){
            // System.out.println("Left " + left);
            // System.out.println("Right " + right);
            boolean isAllCharPresent = true; 
            for(char c : s1.toCharArray()){
                if(!windowCharSet.contains(c)){
                    isAllCharPresent = false; 
                    break;
                }
            }
            if(isAllCharPresent){
                // System.out.println("Left " + left );
                // System.out.println("Right " + right );
                return true; 
            } 

            windowCharSet.remove(s2.charAt(left)); 
            left ++; 
            right ++; 
            if(right < s2.length()) windowCharSet.add(s2.charAt(right)); 

        }

        return false; 
    }
}

// ab, ba

// eidbaooo
