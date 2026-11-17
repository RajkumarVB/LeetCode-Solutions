class Solution {
    public boolean isPalindrome(int x) {
        if(x <0) return false ; 
        int temp = x ; 
        int reverseNumber = 0 ;  
        while(temp >0){
            reverseNumber = (temp % 10) + (reverseNumber *10) ;
            temp /=10 ; 
        }
        if(reverseNumber == x) return true ; 
        return false ;
    }
}