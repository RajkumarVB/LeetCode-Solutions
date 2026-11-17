class Solution {
    public boolean isPalindrome(String s) {
        int i =0 ,j = s.length() -1;  
        s = s.toLowerCase(); 
        while(i < j){
            if(!isLowerCaseCharacter(s.charAt(i))){
                i++; 
                continue; 
            }
            if(!isLowerCaseCharacter(s.charAt(j))){
                j--; 
                continue; 
            }

            if(s.charAt(i) != s.charAt(j)){
                return false; 
            }
            i++; 
            j--; 
        }
        return true; 
    }

    private boolean isLowerCaseCharacter(char c){
        int asciiValue = (int) c; 
        int aAsciiValue = (int) 'a';
        int zAsciiValue = (int) 'z';

        if((asciiValue > zAsciiValue) ||  (asciiValue < aAsciiValue)){
            return false; 
        }
        return true; 

    }
}