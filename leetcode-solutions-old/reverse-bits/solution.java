public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0; 
        for(int i =1 ; i<=32; i++){
            result = result << 1; 
            int lastBit = (n & 1); 
            result |= lastBit; 
            n >>=1 ; 
        }
        return result; 
    }
}