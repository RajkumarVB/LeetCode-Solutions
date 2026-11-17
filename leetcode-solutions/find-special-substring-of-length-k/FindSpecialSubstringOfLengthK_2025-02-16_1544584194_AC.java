class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int i=0, j=k-1, n = s.length(); 
        while(j<n){
            boolean isSpecial = true; 
            char windowChar = s.charAt(i); 
            for(int index =i+1; index<=j; index++){
                if(windowChar != s.charAt(index)){
                    isSpecial = false;
                    break; 
                }
            }
            if(isSpecial == true && i !=0 && s.charAt(i-1) == windowChar){
                isSpecial = false;
            }

            if(isSpecial == true && j != n-1 && s.charAt(j+1) == windowChar){
                isSpecial = false;
            }

            if(isSpecial == true){
                return true; 
            }

            j++;
            i++; 
        }
        return false; 
    }
}
