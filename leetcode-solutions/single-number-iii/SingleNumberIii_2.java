/*
 * 260. Single Number III  [Medium]
 * https://leetcode.com/problems/single-number-iii/
 * Topics: Array, Bit Manipulation
 *
 * Problem:     Exactly two elements appear once and all others twice. Find the two, in O(n)
 *              time and O(1) space.
 * Example:     [1,2,1,3,2,5] -> [3,5]
 * Constraints: n <= 3e4
 *
 * Key idea:    XOR all gives a ^ b (non-zero). Isolate any set bit (x & -x); it separates a
 *              from b. XOR each group separately to get each number.
 *
 * Approach:    HashMap counting
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: XOR all + split by lowest set bit
 * Submitted:   2024-03-10 (submission 1199702188, AC)
 */

class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>(); 
        for(int ele : nums){
            int count = map.getOrDefault(ele,0);
            map.put(ele,count+1); 
        }
        List<Integer> result = new LinkedList<>();
        for(var entry : map.entrySet()){
            if(entry.getValue() == 1) result.add(entry.getKey()); 
        }
        return new int[]{result.get(0), result.get(1)}; 
    }
}