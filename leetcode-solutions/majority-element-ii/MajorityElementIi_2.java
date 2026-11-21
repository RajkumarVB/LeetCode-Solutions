/*
 * 229. Majority Element II  [Medium]
 * https://leetcode.com/problems/majority-element-ii/
 * Topics: Array, Hash Table, Sorting, Counting, Boyer–Moore Majority Vote Algorithm
 *
 * Problem:     Return all elements appearing more than n/3 times.
 * Example:     [3,2,3] -> [3]
 * Constraints: n <= 5e4
 *
 * Key idea:    At most two such elements exist. Extended Boyer-Moore with two candidates
 *              and two counts, then a second pass to verify each candidate's count.
 *
 * Approach:    HashMap counting
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: Boyer-Moore with two candidates + verify
 * Submitted:   2023-12-27 (submission 1129857368, AC)
 */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>(); 
        int n = nums.length; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        for(int element : nums){
            int count = map.getOrDefault(element,0);
            map.put(element, count + 1 ); 
        }

        for(var entry : map.entrySet()){
            if(entry.getValue() > n/3 ){
                ans.add(entry.getKey());
            }
        }

        return ans; 
    }
}