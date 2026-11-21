/*
 * 88. Merge Sorted Array  [Easy]
 * https://leetcode.com/problems/merge-sorted-array/
 * Topics: Array, Two Pointers, Sorting
 *
 * Problem:     nums1 has m values followed by n empty slots; merge sorted nums2 into it in
 *              place.
 * Example:     [1,2,3,0,0,0], [2,5,6] -> [1,2,2,3,5,6]
 * Constraints: m + n <= 200
 *
 * Key idea:    Fill from the back: compare the largest remaining of each array and write it
 *              at index m+n-1, moving backwards. No extra array needed.
 *
 * Approach:    Merge into a temporary list, copy back
 * Complexity:  time O(m + n), space O(m + n)
 * Submitted:   2023-12-23 (submission 1126806518, AC)
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        LinkedList<Integer> result = new LinkedList<>(); 
        int i =0, j=0; 

        while(i <m && j<n){
            if(nums1[i] < nums2[j]){
                result.add(nums1[i]);
                i++; 
            } else{
                result.add(nums2[j]);
                j++; 
            }
        }

        while(i<m){
            result.add(nums1[i]);
            i++; 
        }

        while(j <n){
            result.add(nums2[j]);
            j++; 
        }

        for(int k=0; k<result.size(); k++){
            nums1[k] = result.get(k); 
        }

    }
}