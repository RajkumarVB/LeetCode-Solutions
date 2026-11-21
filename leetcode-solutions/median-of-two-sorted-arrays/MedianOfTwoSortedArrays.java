/*
 * 4. Median of Two Sorted Arrays  [Hard]
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Topics: Array, Binary Search, Divide and Conquer
 *
 * Problem:     Return the median of two sorted arrays in O(log(m+n)).
 * Example:     [1,3], [2] -> 2.0; [1,2], [3,4] -> 2.5
 * Constraints: m, n <= 1000
 *
 * Key idea:    Binary search the partition in the smaller array: take i from nums1 and half
 *              - i from nums2. The partition is correct when l1 <= r2 and l2 <= r1; then
 *              the median comes from max(l1,l2) and min(r1,r2). Use +/- infinity at the
 *              edges.
 *
 * Approach:    Binary search on partition of smaller array
 * Complexity:  time O(log min(m,n)), space O(1)
 * Submitted:   2025-02-16 (submission 1545304794, AC)
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2; 

        if(n1 > n2) return findMedianSortedArrays(nums2, nums1); 
        int noOfLeftElements = (n) /2;
        // 10 -> 5 on the left, 5 on the right
        // 9 -> 5 on the left, 4 on the right

        int left = 0 ,right = n1; 
        while(left <= right){
            // mid1 means how many elements you're picking from arr1
            int mid1 = (right - left)/2 + left; 

            int mid2 = noOfLeftElements - mid1; 

            int l1 = (mid1 - 1 >= 0)? nums1[mid1-1] : Integer.MIN_VALUE; 
            int l2 = (mid2 - 1 >= 0)? nums2[mid2-1] : Integer.MIN_VALUE; 

            int r1 = (mid1 <n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 <n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0; 
                }else{
                    return Math.min(r1,r2);
                }
            }else if(l1 > r2){
                right = mid1 -1; 
            }else{
                left = mid1 + 1; 
            }
        }
        return -1; 
    }
}