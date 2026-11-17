class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        int i =0, j =0;
        while(j<n && i<=j){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            } else{
                result = Math.max(result, j-i+1);
                set.add(s.charAt(j));
                j++;
            }
        }
        return result;
    }
}
  
   