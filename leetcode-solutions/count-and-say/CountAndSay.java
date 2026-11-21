/*
 * 38. Count and Say  [Medium]
 * https://leetcode.com/problems/count-and-say/
 * Topics: String
 *
 * Problem:     countAndSay(1) = "1"; each next term is the run-length encoding of the
 *              previous term (count then digit). Return the nth term.
 * Example:     n=4 -> "1211" (1 -> 11 -> 21 -> 1211)
 * Constraints: n <= 30
 *
 * Key idea:    Build each term from the previous one by scanning runs of equal characters
 *              and appending count + char.
 *
 * Approach:    Recursion + run-length encoding scan
 * Complexity:  time O(total length), space O(length)
 * Submitted:   2023-12-31 (submission 1132815278, AC)
 */

class Solution {
    public String countAndSay(int n) {
        if(n ==1) return "1"; 
        String tempAns = countAndSay(n-1);
        return say(tempAns); 
    }

    public String say(String s){
        if(s == null || s.length() ==0) return ""; 
        
        int n = s.length(); 
        int i=0, j=0, count = 0; 

        StringBuilder ans = new StringBuilder(); 
        while(j < n){
            if(s.charAt(i) == s.charAt(j)){
                count ++; 
                j++; 
            } else {
                char charCount = (char) ('0' + count); 
                ans.append(charCount); 
                ans.append(s.charAt(i));  
                
                i = j; 
                count = 0; 
            }
        }
        char charCount = (char) ('0' + count); 
        ans.append(charCount); 
        ans.append(s.charAt(i));  

        return ans.toString(); 
    }
}