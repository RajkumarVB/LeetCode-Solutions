/*
 * 217. Contains Duplicate  [Easy]
 * https://leetcode.com/problems/contains-duplicate/
 * Topics: Array, Hash Table, Sorting
 *
 * Problem:     Return true if any value appears at least twice in the array.
 * Example:     [1,2,3,1] -> true
 * Constraints: n <= 1e5
 *
 * Key idea:    Use a HashSet and return as soon as a value is already in it. (Sorting and
 *              checking neighbours is O(n log n) with O(1) extra space.)
 *
 * Approach:    HashSet early exit
 * Complexity:  time O(n), space O(n)
 * Submitted:   2026-09-02 (submission 2128679962, AC)
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length; 
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true; 
            }
            set.add(num);
        }
        return false; 
    }
}