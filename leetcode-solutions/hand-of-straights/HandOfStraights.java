/*
 * 846. Hand of Straights  [Medium]
 * https://leetcode.com/problems/hand-of-straights/
 * Topics: Array, Hash Table, Greedy, Sorting
 *
 * Problem:     Can the cards be split into groups of groupSize consecutive values?
 * Example:     hand=[1,2,3,6,2,3,4,7,8], groupSize=3 -> true
 * Constraints: n <= 1e4
 *
 * Key idea:    The smallest remaining card must start a group. Count with a map, take the
 *              smallest key from a min-heap, consume first..first+size-1. If a count hits 0
 *              out of order, fail.
 *
 * Approach:    Count map + min-heap of distinct values
 * Complexity:  time O(n log n), space O(n)
 * Submitted:   2024-02-28 (submission 1188488023, AC)
 */

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> map = new HashMap<>(); 
        for(int ele : hand){
            int count = map.getOrDefault(ele,0);
            map.put(ele, count+1); 
        }
        PriorityQueue<Integer> mHeap = new PriorityQueue(map.keySet()); 
        while(!mHeap.isEmpty()){
            int first = mHeap.peek(); 
            for(int i = first; i < first+groupSize ; i++){
                if(!map.containsKey(i)) return false; 
                int count = map.get(i); 
                map.put(i,count -1); 
                if(map.get(i) ==0){
                    if(i != mHeap.peek()) return false; 
                    mHeap.poll(); 
                }
            }
        }
        return true; 
    }
}