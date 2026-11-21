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
 * Approach:    Fix one + HashSet two-sum, dedupe sorted triples in a Set
 * Complexity:  time O(n^2), space O(n)
 * Also see:    _1: Sort + fix one + two pointers, skip duplicates
 * Submitted:   2024-01-22 (submission 1153372216, AC)
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length; 
        HashSet<List<Integer>> result = new HashSet<>();
        for(int i=0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int thirdElement = -(nums[i] + nums[j]); 
                if(set.contains(thirdElement)){
                    List<Integer> tempAns = new LinkedList<>(Arrays.asList(nums[i],nums[j],thirdElement)); 
                    tempAns.sort(null);
                    result.add(tempAns); 
                }
                set.add(nums[j]); 
            }
        }
        return new LinkedList<>(result); 
    }
}