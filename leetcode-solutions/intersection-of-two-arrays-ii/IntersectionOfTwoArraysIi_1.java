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
 * Approach:    Frequency map of one array
 * Complexity:  time O(n + m), space O(n)
 * Also see:    _2: Sort both + two pointers
 * Submitted:   2023-12-27 (submission 1129136734, AC)
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums2){
            if(map.get(i) != null && map.get(i) > 0){
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] result = new int[list.size()]; 
        for(int i = 0; i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}