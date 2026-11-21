/*
 * 171. Excel Sheet Column Number  [Easy]
 * https://leetcode.com/problems/excel-sheet-column-number/
 * Topics: Math, String
 *
 * Problem:     Convert an Excel column title (A, B, ..., Z, AA, AB, ...) into its column
 *              number.
 * Example:     "AB" -> 28
 * Constraints: length <= 7
 *
 * Key idea:    It's base-26 with digits 1..26: result = result * 26 + (c - 'A' + 1),
 *              scanning left to right.
 *
 * Approach:    Base-26 conversion from the right with powers
 * Complexity:  time O(n), space O(1)
 * Submitted:   2023-12-27 (submission 1129490821, AC)
 */

class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length(); 
        int result = 0; 
        int pow = 0; 
        for(int i=n-1; i>=0; i--){
            int value = getValue(columnTitle.charAt(i));
            result += (value * Math.pow(26, pow)); 
            pow ++; 
        }
        return result; 
    }
    public static int getValue(char c){
        return (c - 'A' + 1) ;
    }
}