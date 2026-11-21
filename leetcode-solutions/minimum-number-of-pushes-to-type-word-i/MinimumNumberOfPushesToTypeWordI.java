/*
 * 3014. Minimum Number of Pushes to Type Word I  [Easy]
 * https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/
 * Topics: Math, String, Greedy
 *
 * Problem:     Remap distinct letters onto keys 2-9 (any number per key). Typing the kth
 *              letter on a key costs k pushes. Minimise the total pushes to type a word
 *              with distinct letters.
 * Example:     "xycdefghij" -> 12
 * Constraints: <= 26 distinct letters
 *
 * Key idea:    8 keys: the first 8 letters cost 1 push each, the next 8 cost 2, and so on.
 *              Answer = sum over i of (i / 8 + 1).
 *
 * Approach:    Greedy fill 8 keys per push level
 * Complexity:  time O(26 log 26), space O(26)
 * Submitted:   2024-01-21 (submission 1152843344, AC)
 */

class Solution {
    public int minimumPushes(String word) {
        int n = word.length(); 
        ArrayList<Integer> charCount = new ArrayList<>();
        for(int i=0; i<26; i++) charCount.add(0); 
        for(char c : word.toCharArray()){
            int count = charCount.get(c-'a') ; 
            charCount.set(c-'a',count+1); 
        }
        charCount.sort((a,b) -> b-a); 
        for(int count : charCount) System.out.print(count + " ");
        int result = 0; 
        int pos =1; 
        for(int i=0; i<26; i+=8){
            for(int j = i;j<n && j <i+8; j++){
                result += charCount.get(j) * pos; 
            }
            pos ++; 
        }
        return result; 
    }
}