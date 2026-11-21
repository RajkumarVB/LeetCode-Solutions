/*
 * 131. Palindrome Partitioning  [Medium]
 * https://leetcode.com/problems/palindrome-partitioning/
 * Topics: String, Dynamic Programming, Backtracking
 *
 * Problem:     Return all ways to split s so that every piece is a palindrome.
 * Example:     "aab" -> [[a,a,b],[aa,b]]
 * Constraints: n <= 16
 *
 * Key idea:    Backtracking: from index start, try every end where s[start..end] is a
 *              palindrome, add it, and recurse from end+1.
 *
 * Approach:    Backtracking with palindrome check
 * Complexity:  time O(n * 2^n), space O(n)
 * Submitted:   2024-03-17 (submission 1206198796, AC)
 */

class Solution {
    List<List<String>> result = new LinkedList<>(); 
    public List<List<String>> partition(String s) {
        backtrack(s,0,new LinkedList<>()); 
        return result; 
    }
    public void backtrack(String s, int idx, List<String> tempResult){
        if(idx == s.length()){
            result.add(new LinkedList<>(tempResult));
            return; 
        }
        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s,idx,i)){
                tempResult.add(s.substring(idx,i+1));
                backtrack(s,i+1,tempResult);
                tempResult.removeLast(); 
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false; 
            }
            start ++; 
            end --; 
        }
        return true; 
    }
}