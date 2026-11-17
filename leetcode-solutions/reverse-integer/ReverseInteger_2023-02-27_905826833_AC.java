class Solution {
    public int reverse(int x) {
        long reverseNumber =0 ; 
        int temp =x ; 
        if(x<0)
            temp = x * -1 ;
        while(temp >0){
            reverseNumber = (temp%10) + (reverseNumber * 10) ;
            temp /=10 ;
        }
        if(reverseNumber > Integer.MAX_VALUE || reverseNumber < Integer.MIN_VALUE)
            return 0 ; 
        if(x < 0) return (int) (reverseNumber * -1) ; 
        return (int) (reverseNumber) ; 
    }
}