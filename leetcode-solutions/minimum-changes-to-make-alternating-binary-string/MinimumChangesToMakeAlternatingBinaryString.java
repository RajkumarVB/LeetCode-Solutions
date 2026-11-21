/*
 * 1758. Minimum Changes To Make Alternating Binary String  [Easy]
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 * Topics: String
 *
 * Problem:     Return the minimum number of bit flips to make a binary string alternate (no
 *              two adjacent equal).
 * Example:     "0100" -> 1
 * Constraints: n <= 1e4
 *
 * Key idea:    Only two targets exist: 0101... and 1010.... Count mismatches against the
 *              first (x); the other needs n - x. Answer = min(x, n - x).
 *
 * Approach:    Count mismatches for both patterns
 * Complexity:  time O(n), space O(1)
 * Submitted:   2023-12-24 (submission 1127425234, AC)
 */

class Solution {
    private HashMap<Character,Character> complementMap = new HashMap<>(); 
    public int minOperations(String s) {
        this.initializeMap();

        char firstChar =s.charAt(0); 

        int count1 = this.calcMinOperations(s,firstChar);
        int count2 = this.calcMinOperations(s,complementMap.get(firstChar)) + 1; // + 1, because we assumed the firstChar to be opposite, to change the first char, 1 operations
        return Math.min(count1, count2);

    }
    public void initializeMap(){
        complementMap.put('0','1');
        complementMap.put('1','0');
    }

    public int calcMinOperations(String s, char lastChar){
        int n = s.length(); 
        int result =0; 

        for(int i=1; i<n; i++){
           char currentChar = s.charAt(i);
           if(complementMap.get(currentChar) != lastChar){
               result++; 
           }

           lastChar = complementMap.get(lastChar); 
        }
        return result; 
    }
}