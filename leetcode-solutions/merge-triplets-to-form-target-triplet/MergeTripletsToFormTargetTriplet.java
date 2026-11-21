/*
 * 1899. Merge Triplets to Form Target Triplet  [Medium]
 * https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
 * Topics: Array, Greedy
 *
 * Problem:     You can merge triplets by taking element-wise maximums. Can you produce
 *              exactly the target triplet?
 * Example:     [[2,5,3],[1,8,4],[1,7,5]], target=[2,7,5] -> true
 * Constraints: n <= 1e5
 *
 * Key idea:    Ignore any triplet with a value larger than the target in some position (it
 *              would overshoot). From the rest, check that each target coordinate is
 *              matched exactly by some triplet.
 *
 * Approach:    Filter overshooting triplets, collect matched indices
 * Complexity:  time O(n), space O(1)
 * Submitted:   2024-02-29 (submission 1189681792, AC)
 */

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        HashSet<Integer> result = new HashSet<>(); 
        for(int[] triplet : triplets){
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) 
                continue; 
            for(int i=0; i<triplet.length; i++){
                if(triplet[i] == target[i]) result.add(i); 
            }
        }
        return result.size() == 3; 
    }
}