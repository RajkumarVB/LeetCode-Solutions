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
 * Approach:    Sort + two fixed indices + two pointers
 * Complexity:  time O(n^3), space O(1) extra
 * Also see:    _2: Three loops + HashSet lookup for the fourth
 * Submitted:   2023-12-28 (submission 1130722366, AC)
 */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>(); 
        int n = nums.length; 
        
        Arrays.sort(nums); 

        for(int i=0; i<n; i++){
            if(i !=0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1 ; j<n ; j++){
                if(j != i+1 && nums[j] == nums[j-1]) continue; 

                int k = j +1; 
                int l = n -1; 
                while(k < l){
                    long sum  = (long)nums[i] + nums[j] + nums[k] + nums[l]; 
                    if(sum ==target){
                        List<Integer> tempAns = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        ans.add(tempAns);
                        k ++; l--;

                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    } else if (sum < target){
                        k++; 
                    } else{
                        l--; 
                    }
                }
            }
        }
        return ans; 
    }
}