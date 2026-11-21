/*
 * 1496. Path Crossing  [Easy]
 * https://leetcode.com/problems/path-crossing/
 * Topics: Hash Table, String
 *
 * Problem:     Walk a path of N/S/E/W unit moves from the origin. Return true if you ever
 *              revisit a point.
 * Example:     "NESWW" -> true
 * Constraints: n <= 1e4
 *
 * Key idea:    Track visited coordinates in a HashSet. The key must be value-based: a
 *              record, a "x,y" string, or a class overriding equals/hashCode.
 *
 * Approach:    HashSet of (x, y) pairs
 * Complexity:  time O(n), space O(n)
 * Submitted:   2023-12-23 (submission 1126412307, AC)
 */

class Solution {
        public static boolean isPathCrossing(String path) {
        HashSet<Pair<Integer,Integer>> visited = new HashSet<>();
        
        int x = 0; 
        int y = 0; 

        Pair<Integer,Integer> p = new Pair(0,0);
        visited.add(p);

        for(char c : path.toCharArray()){
            if(c == 'N'){
                y += 1; 
            } else if(c == 'S'){
                y -=1; 
            } else if(c =='E'){
                x +=1 ; 
            } else{
                x -= 1; 
            }
            p = new Pair(x, y); 

            if(visited.contains(p)) return true;
            visited.add(p);
        }
        
        return false;
    }
}