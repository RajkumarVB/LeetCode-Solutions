class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n <= 1) return n; 
        int i,j; 
        i=0; 
        j =0; 
        int result =0; 
        HashSet<Character> set = new HashSet<>(); 
        while(j < n){
            char c = s.charAt(j); 
            if(!set.contains(c)){
                result = Math.max(result,j-i+1);
                set.add(c); 
                j++; 
            } else{
                set.remove(s.charAt(i)); 
                i++; 
            }
        }
        return result; 
    }
}