public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0; 
        for(int i=1; i<=32; i++){
            int lastBit = (n & (1 <<31)); 
            if(lastBit !=0) count ++; 
            n <<=1; 
        }
        return count; 
    }
}