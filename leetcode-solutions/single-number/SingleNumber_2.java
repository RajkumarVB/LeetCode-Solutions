/*
 * 136. Single Number  [Easy]
 * https://leetcode.com/problems/single-number/
 * Topics: Array, Bit Manipulation
 *
 * Problem:     Every element appears twice except one. Find it in O(n) time and O(1) space.
 * Example:     [4,1,2,1,2] -> 4
 * Constraints: n <= 3e4
 *
 * Key idea:    XOR everything: x ^ x = 0 and x ^ 0 = x, so pairs cancel and the single
 *              value remains.
 *
 * Approach:    HashMap counting
 * Complexity:  time O(n), space O(n)
 * Also see:    _1: XOR of all elements
 * Submitted:   2023-08-20 (submission 1026725013, AC)
 */

class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length; 
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(var element : nums){
            int count = hashMap.getOrDefault(element,0);
            hashMap.put(element, count+1);
        }
        // for(var element : hashMap.entrySet()){
        //     System.out.print(element.getKey() +"->" + element.getValue());
        //     System.out.println();
        // }
        for(var item : hashMap.entrySet()){
            if(item.getValue() ==1){
                return item.getKey();
            }
        }
        return -1;
    }
}