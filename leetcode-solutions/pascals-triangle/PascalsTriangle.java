/*
 * 118. Pascal's Triangle  [Easy]
 * https://leetcode.com/problems/pascals-triangle/
 * Topics: Array, Dynamic Programming
 *
 * Problem:     Return the first numRows rows of Pascal's triangle.
 * Example:     5 -> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Constraints: numRows <= 30
 *
 * Key idea:    Each inner entry is the sum of the two above it: row[j] = prev[j-1] +
 *              prev[j]. Alternatively build each row directly with C(r, j) = C(r, j-1) * (r
 *              - j) / j.
 *
 * Approach:    Each row from the binomial-coefficient formula
 * Complexity:  time O(numRows^2), space O(1) extra
 * Submitted:   2023-12-27 (submission 1129435570, AC)
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>(); 
        for(int i=1; i<= numRows; i++){
            List<Integer> row = generateRow(i);
            result.add(row); 
        }
        return result; 
    }
    public static List<Integer> generateRow(int row){
        List<Integer> ans = new LinkedList<>(); 
        int val = 1;

        ans.add(val); 

        for(int i=1; i<row; i++){
            val *= (row - i);
            val /= i; 
            ans.add(val); 
        }

        return ans; 
    }
}