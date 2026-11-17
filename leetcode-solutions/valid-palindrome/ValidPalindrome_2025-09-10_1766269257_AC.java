class Solution {
    public boolean isPalindrome(String s) {
        int i =0 ,j = s.length() -1;  
        s = s.toLowerCase(); 
        while(i < j){
            char iChar = s.charAt(i); 
            char jChar = s.charAt(j); 
            if(!isLowerCaseCharacter(iChar) && !isNumericCharacter(iChar)){
                i++; 
                continue; 
            }
            if(!isLowerCaseCharacter(jChar) && !isNumericCharacter(jChar)){
                j--; 
                continue; 
            }

            if(iChar != jChar){
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

    private boolean isNumericCharacter(char c){
        int asciiValue = (int) c; 
        int aAsciiValue = (int) '0';
        int zAsciiValue = (int) '9';

        if((asciiValue > zAsciiValue) ||  (asciiValue < aAsciiValue)){
            return false; 
        }
        return true; 

    }
}