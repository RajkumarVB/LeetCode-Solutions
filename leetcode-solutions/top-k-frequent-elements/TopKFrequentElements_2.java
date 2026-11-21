/*
 * 347. Top K Frequent Elements  [Medium]
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Topics: Array, Hash Table, Divide and Conquer, Sorting, Heap (Priority Queue), Bucket
 *         Sort, Counting, Quickselect
 *
 * Problem:     Return the k most frequent elements.
 * Example:     [1,1,1,2,2,3], k=2 -> [1,2]
 * Constraints: n <= 1e5, better than O(n log n)
 *
 * Key idea:    Count with a map. Bucket sort by frequency (index = count, at most n) and
 *              read buckets from high to low: O(n). A heap is O(n log n), or O(n log k)
 *              with a size-k min-heap.
 *
 * Approach:    Frequency map + max-heap
 * Complexity:  time O(n log n), space O(n)
 * Also see:    _1: Frequency map + bucket sort
 * Submitted:   2025-09-03 (submission 1758462036, AC)
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for(int num : nums){
            int count = countMap.getOrDefault(num,0);
            countMap.put(num, count +1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> {
                return (b.count - a.count); 
            }
        );

        for(var entry : countMap.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();

            Pair p = new Pair(num, count);
            pq.add(p);
        }
        List<Integer> result = new LinkedList<>();
        while(k !=0){
            Pair p = pq.poll();
            result.add(p.number);
            k--; 
        }
        return result.stream().mapToInt(num -> num.intValue()).toArray();

    }
    class Pair{
        int number; 
        int count; 
        public Pair(int number, int count){
            this.number = number; 
            this.count = count; 
        }
    }
}