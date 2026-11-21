/*
 * 13. Roman to Integer  [Easy]
 * https://leetcode.com/problems/roman-to-integer/
 * Topics: Hash Table, Math, String
 *
 * Problem:     Convert a Roman numeral to an integer.
 * Example:     "MCMXCIV" -> 1994
 * Constraints: 1..3999
 *
 * Key idea:    Scan left to right: if a symbol is smaller than the one after it (IV, IX,
 *              XL, ...), subtract it; otherwise add it.
 *
 * Approach:    Subtract when smaller than the next symbol
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: Lookup table for the six two-letter exceptions
 * Submitted:   2023-12-22 (submission 1125990722, AC)
 */

class Solution {
    public int romanToInt(String s) {
        
        HashMap<Character, Integer> valueMap = new HashMap<>(); 
        initializeValueMap(valueMap); 

        int result = 0; 
        for(int i=0 ; i<s.length(); i++){
            if(i != (s.length() -1) && valueMap.get(s.charAt(i)) < valueMap.get(s.charAt(i+1))){
                result -= valueMap.get(s.charAt(i)); 
            } else{
                result += valueMap.get(s.charAt(i)); 
            }
        }
        return result ;  
    }

    public static void initializeValueMap(HashMap<Character, Integer> valueMap){
        valueMap.put('I',1);
        valueMap.put('V',5);
        valueMap.put('X',10);
        valueMap.put('L',50);
        valueMap.put('C',100);
        valueMap.put('D',500);
        valueMap.put('M',1000);
    }
}