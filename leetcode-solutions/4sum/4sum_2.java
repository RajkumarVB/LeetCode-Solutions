/*
 * 18. 4Sum  [Medium]
 * https://leetcode.com/problems/4sum/
 * Topics: Array, Two Pointers, Sorting
 *
 * Problem:     Return all unique quadruples of values whose sum equals target.
 * Example:     nums=[1,0,-1,0,-2,2], target=0 -> [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Constraints: n <= 200, values up to 1e9 (sum can overflow int)
 *
 * Key idea:    Same idea as 3Sum with one more fixed loop: two nested loops + two pointers.
 *              Use long for the sum to avoid overflow.
 *
 * Approach:    Three loops + HashSet lookup for the fourth
 * Complexity:  time O(n^3), space O(n)
 * Also see:    _1: Sort + two fixed indices + two pointers
 * Submitted:   2023-12-28 (submission 1130729936, AC)
 */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> ans = new HashSet<>(); 
        int n = nums.length; 
        
        HashSet<Long> set = new HashSet<>(); 

        for(int i=0; i<n; i++){
            for(int j = i+1; j<n; j++){
                set.clear(); 
                for(int k = j+1; k<n; k++){
                    long fourthNumber = (long)target - nums[i] - nums[j] - nums[k] ;
                    if(set.contains(fourthNumber)){
                        List<Integer> tempAns = Arrays.asList(nums[i],nums[j],nums[k], (int)fourthNumber); 
                        tempAns.sort(null); 
                        ans.add(tempAns); 
                    }
                    set.add((long)nums[k]); 
                }
            }
        }

        return new LinkedList<>(ans); 
    }
}