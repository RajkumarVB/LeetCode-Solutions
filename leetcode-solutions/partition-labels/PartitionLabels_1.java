/*
 * 763. Partition Labels  [Medium]
 * https://leetcode.com/problems/partition-labels/
 * Topics: Hash Table, Two Pointers, String, Greedy
 *
 * Problem:     Split s into as many parts as possible so each letter appears in at most one
 *              part. Return the part sizes.
 * Example:     "ababcbacadefegdehijhklij" -> [9,7,8]
 * Constraints: n <= 500
 *
 * Key idea:    Record each letter's last index. Scan, extending the current part's end to
 *              max(end, last[c]); when i == end, close the part.
 *
 * Approach:    Last-index map + greedy extend
 * Complexity:  time O(n), space O(1)
 * Also see:    _2: Remaining-count map, close when all seen counts hit 0
 * Submitted:   2024-02-29 (submission 1189909623, AC)
 */

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastIndexMap = new HashMap<>(); 
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i); 
            lastIndexMap.put(c,i); 
        }
        int count =0, end = 0; 
        List<Integer> result = new LinkedList<>(); 
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i); 

            end = Math.max(end,lastIndexMap.get(c));
            count++; 
            if(end == i){
                result.add(count);
                count =0; 
            }
        }
        return result; 
    }
}