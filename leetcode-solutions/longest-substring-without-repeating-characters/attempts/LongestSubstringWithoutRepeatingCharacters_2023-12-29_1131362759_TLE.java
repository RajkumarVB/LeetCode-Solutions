class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(); 
        int result = 0; 
        for(int i=0; i<n ;i++){
            for(int j=i; j<n; j++){
                if(isLSWRC(s,i,j)){
                    result = Math.max(result, j-i+1); 
                }
            }
        }
        return result; 
    }

    public static boolean isLSWRC(String s, int i, int j){
        HashSet<Character> set = new HashSet<>(); 
        for(int k =i; k<=j; k++){
            if(set.contains(s.charAt(k))) return false; 
            set.add(s.charAt(k)); 
        }
        return true; 
    }


}