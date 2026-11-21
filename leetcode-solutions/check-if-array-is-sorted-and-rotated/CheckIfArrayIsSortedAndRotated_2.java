/*
 * 1752. Check if Array Is Sorted and Rotated  [Easy]
 * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 * Topics: Array
 *
 * Problem:     Return true if the array is a non-decreasing array rotated by some amount
 *              (possibly zero).
 * Example:     [3,4,5,1,2] -> true; [2,1,3,4] -> false
 * Constraints: n <= 100
 *
 * Key idea:    Count the 'drops' where nums[i] > nums[(i+1) % n] (circularly). A sorted-
 *              and-rotated array has at most one drop.
 *
 * Approach:    Brute force: try every rotation
 * Complexity:  time O(n^2), space O(1)
 * Also see:    _1: Count circular drops (<= 1)
 * Submitted:   2023-08-19 (submission 1025745908, AC)
 */

class Solution {
    public boolean check(int[] nums) {
        // printArray(nums); 
        if(isSorted(nums)) return true; 
        for(int i=0; i<nums.length -1; i++){
            rightRotate(nums);
            if(isSorted(nums)) return true; 
            // printArray(nums);
        }
        return false ; 
    }

    public static void printArray(int[] nums){
        for(int element : nums ){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void rightRotate(int[] nums){
        int n = nums.length; 
        int temp = nums[n-1];
        for(int i = n-1; i>0 ; i--){
            nums[i]= nums[i-1]; 
        }
        nums[0] = temp; 
    }

    public static boolean isSorted(int [] nums){
        for(int i=0;i<nums.length-1; i++ ){
            if(nums[i] > nums[i+1]) return false ; 
        }
        return true; 
    }
}

// [3,4,5,1,2] -> Before Rotation would be 1 2 3 4 5 
// [2,1,3,4] -> 4 2 1 3 -> 3 4 2 1 -> 4 2 1   
// [1,2,3] -> 

//[3,4,5,1,2] -> 2 3 4 5 1 -> 1 2 3 4 5 