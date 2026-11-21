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
 * Approach:    Remaining-count map, close when all seen counts hit 0
 * Complexity:  time O(26n), space O(1)
 * Also see:    _1: Last-index map + greedy extend
 * Submitted:   2024-02-29 (submission 1189694284, AC)
 */

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>(); 
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1); 
        }
        HashSet<Character> seenChars = new HashSet<>();
        int splitCount =0; 
        List<Integer> result = new LinkedList<>(); 
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) -1);
            seenChars.add(c);
            splitCount ++; 
            boolean seenCharsCount = false; 
            for(char sc : seenChars){
                if(map.get(sc) != 0){
                    seenCharsCount = true; 
                    break; 
                }
            }
            if(!seenCharsCount){
                result.add(splitCount); 
                splitCount =0; 
                seenChars.clear(); 
            }
        }
        return result; 
    }
}

//ababcbacadefegdehijhklij
// ababcbaca defegde hijhklij