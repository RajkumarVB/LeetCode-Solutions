/*
 * 443. String Compression  [Medium]
 * https://leetcode.com/problems/string-compression/
 * Topics: Two Pointers, String
 *
 * Problem:     Compress a char array in place: each run becomes the char followed by its
 *              count (if > 1). Return the new length.
 * Example:     [a,a,b,b,c,c,c] -> 6, [a,2,b,2,c,3]
 * Constraints: n <= 2000
 *
 * Key idea:    Read pointer scans runs; write pointer writes the char and then each digit
 *              of the count. Writing never overtakes reading.
 *
 * Approach:    Read/write pointers over runs
 * Complexity:  time O(n), space O(1)
 * Submitted:   2024-02-13 (submission 1173967385, AC)
 */

class Solution {
    public int compress(char[] chars) {
        int n = chars.length; 
        int toAddIdx = 0 ; 
        int i = 0; 
        while(i < n){
            char c = chars[i]; 
            int count = 0; 
            while(i<n && chars[i] == c){
                count ++; 
                i ++; 
            }
            chars[toAddIdx] = c; 
            toAddIdx++; 
            if(count > 1){
                String countStr = String.valueOf(count); 
                for(char countC : countStr.toCharArray()){
                    chars[toAddIdx] = countC;
                    toAddIdx++; 
                }
            }
        }
        return toAddIdx; 
    }
}