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
        HashMap<Character,Integer> map1 = new HashMap<>(); 
        HashMap<Character,Integer> map2 = new HashMap<>(); 
        for(char c : s1.toCharArray()){
            int count = map1.getOrDefault(c,0); 
            map1.put(c,count+1); 
        }
        for(char c : s2.toCharArray()){
            int count = map2.getOrDefault(c,0); 
            map2.put(c,count+1); 
        }
        for(char key : map2.keySet()){
            if(map1.get(key) != map2.get(key)) return false; 
        }
        return true; 
    }
}