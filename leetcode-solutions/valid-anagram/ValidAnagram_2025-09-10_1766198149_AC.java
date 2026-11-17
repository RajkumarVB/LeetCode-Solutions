class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqStore = new int[26];
        for(char c : s.toCharArray()){
            freqStore[c - 'a']++; 
        }
        for(char c : t.toCharArray()){
            freqStore[c - 'a']--; 
        }
        for(int count : freqStore){
            if(count != 0) return false; 
        }
        return true; 
    }
}