/*
 * 3069. Distribute Elements Into Two Arrays I  [Easy]
 * https://leetcode.com/problems/distribute-elements-into-two-arrays-i/
 * Topics: Array, Two Pointers, Simulation
 *
 * Problem:     Put nums[0] in arr1 and nums[1] in arr2; each next element goes to arr1 if
 *              arr1's last element is greater than arr2's, else to arr2. Return arr1
 *              followed by arr2.
 * Example:     [2,1,3] -> [2,3,1]
 * Constraints: n <= 50
 *
 * Key idea:    Direct simulation.
 *
 * Approach:    Simulation with two lists
 * Complexity:  time O(n), space O(n)
 * Submitted:   2024-03-03 (submission 1192693297, AC)
 */

class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new LinkedList<>();
        List<Integer> arr2 = new LinkedList<>();
        int n = nums.length; 
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i=2; i<n; i++){
            if(arr1.getLast() > arr2.getLast()){
                arr1.add(nums[i]);
            }else{
                arr2.add(nums[i]);
            }
        }
        arr1.addAll(arr2);
        int[] result = new int[n];
        for(int i =0; i<n; i++){
            result[i] = arr1.get(i);
        }
        return result; 
    }
}