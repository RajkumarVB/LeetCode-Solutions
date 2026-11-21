/*
 * 350. Intersection of Two Arrays II  [Easy]
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * Topics: Array, Hash Table, Two Pointers, Binary Search, Sorting
 *
 * Problem:     Return the intersection of two arrays, with each value appearing as many
 *              times as it appears in both.
 * Example:     [1,2,2,1], [2,2] -> [2,2]
 * Constraints: lengths <= 1000
 *
 * Key idea:    Count one array in a map, then walk the other and take a value whenever its
 *              count is still positive (decrementing). If both arrays are sorted, two
 *              pointers need no extra space.
 *
 * Approach:    Sort both + two pointers
 * Complexity:  time O(n log n + m log m), space O(1) extra
 * Also see:    _1: Frequency map of one array
 * Submitted:   2023-12-27 (submission 1129122035, AC)
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> ans = new LinkedList(); 
        
        int i = 0, j =0; 
        int n = nums1.length, m = nums2.length; 

        while(i<n && j<m){
            if(nums1[i] < nums2[j]){
                i++; 
            } else if(nums1[i] == nums2[j]){
                ans.add(nums1[i]);
                i++; 
                j++; 
            } else{
                j++; 
            }
        }

        int[] result = new int[ans.size()]; 
        for(int k=0 ;k<ans.size(); k++){
            result[k] = ans.get(k); 
        }

        return result; 
    }
}