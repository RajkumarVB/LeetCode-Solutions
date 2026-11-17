public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0; 
        for(int i =1 ; i<=32; i++){
            int firstBit = (n & (1 << 31)); 
            firstBit = (firstBit != 0) ? 1 : 0; 
            System.out.println(firstBit); 
            result = (firstBit << 31) | (result >>> 1); 
            n = n << 1; 
        }
        return result; 
    }
}