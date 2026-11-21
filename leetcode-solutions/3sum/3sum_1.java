/*
 * 15. 3Sum  [Medium]
 * https://leetcode.com/problems/3sum/
 * Topics: Array, Two Pointers, Sorting
 *
 * Problem:     Find every unique triple of values in the array whose sum is zero. The same
 *              triple must not be reported twice.
 * Example:     [-1,0,1,2,-1,-4] -> [[-1,-1,2],[-1,0,1]]
 * Constraints: 3 <= n <= 3000
 *
 * Key idea:    Sort, fix the first element, then solve two-sum on the rest with two
 *              pointers. Skip equal neighbours to avoid duplicate triples instead of using
 *              a Set.
 *
 * Approach:    Sort + fix one + two pointers, skip duplicates
 * Complexity:  time O(n^2), space O(1) extra
 * Also see:    _2: Fix one + HashSet two-sum, dedupe sorted triples in a Set
 * Submitted:   2025-03-04 (submission 1562884809, AC)
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length; 
        Arrays.sort(nums); 
        List<List<Integer>> ans = new LinkedList<>(); 
        for(int i=0; i<n; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue; 
            int j = i+1; 
            int k = n-1; 

            while(j < k){
                if(nums[i] + nums[j] + nums[k] < 0){
                    j ++;
                }else if(nums[i] + nums[j] + nums[k] > 0){
                    k --;
                }else{
                    ans.add(List.of(nums[i], nums[j],nums[k]));

                    j++; 
                    k --; 
                    while(j <k && nums[j] == nums[j-1]) j++; 
                    while(j <k && nums[k] == nums[k+1]) k--; 
                }
            }
        }
        return ans; 
    }
}