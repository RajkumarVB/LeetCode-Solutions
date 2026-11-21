/*
 * 189. Rotate Array  [Medium]
 * https://leetcode.com/problems/rotate-array/
 * Topics: Array, Math, Two Pointers
 *
 * Problem:     Rotate an array to the right by k steps, in place if possible.
 * Example:     [1,2,3,4,5,6,7], k=3 -> [5,6,7,1,2,3,4]
 * Constraints: n <= 1e5, k <= 1e5
 *
 * Key idea:    k %= n, then three reversals: whole array, first k, last n-k. O(1) space.
 *
 * Approach:    Temp buffer for the last k elements
 * Complexity:  time O(n), space O(k)
 * Also see:    _1: Three reversals
 * Submitted:   2023-08-31 (submission 1036855632, AC)
 */

class Solution {
    public void rotate(int[] nums, int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        int n = nums.length; 
        k = k%n;
        for(int i = n-k ; i<n ;i++){
            temp.add(nums[i]);
        }
        for(int i = n-1 ; i>=k ; i--){
            nums[i] = nums[i-k]; 
        }
        int x = 0 ;
        for(int i =0; i<k; i++,x++){
            nums[i] = temp.get(x); 
        }
    }
}