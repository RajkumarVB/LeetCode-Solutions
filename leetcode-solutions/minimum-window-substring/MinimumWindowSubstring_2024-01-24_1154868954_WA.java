class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n < m) return ""; 
        for(int windowLen = m; windowLen <= n; windowLen++){
            int i,j; 
            i = 0; 
            j = windowLen -1; 
            while(j < n ){
                if(isPresent(s.substring(i,j+1), t)) return s.substring(i,j+1); 
                i ++; 
                j ++; 
            }
        }
        return ""; 
    }
    public boolean isPresent(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        HashSet<Character> set = new HashSet<>(); 
        for(char c : s1.toCharArray()){
            set.add(c);
        }
        for(int i=0; i<m; i++){
            char c = s2.charAt(i); 
            if(!set.contains(c)) return false; 
        }
        return true; 
    }
}