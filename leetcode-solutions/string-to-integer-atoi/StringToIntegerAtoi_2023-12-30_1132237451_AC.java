class Solution {
    public int myAtoi(String s) {
        
        int n = s.length(); 

        int i =0; 
        boolean isPositive = true; 
        int result = 0; 

        while(i < n && s.charAt(i) ==' ') i++; 
        
        if((i < n) && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            if(s.charAt(i) == '-'){
                isPositive = false; 
            }
            i++; 
        }

        while(i < n && isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0'; 
            digit = (!isPositive) ? -digit : digit ;

            if((result > Integer.MAX_VALUE/10) || (result == Integer.MAX_VALUE/10) && (digit > Integer.MAX_VALUE % 10)) return Integer.MAX_VALUE; 
            if((result < Integer.MIN_VALUE/10) || (result == Integer.MIN_VALUE/10) && (digit < Integer.MIN_VALUE % 10)) return Integer.MIN_VALUE; 

            result *= 10; 
            result += digit; 
            i++;
        }

        return result ;
    }

    public boolean isDigit(char c){
        return (c >= '0' && c<='9') ;
    }
}