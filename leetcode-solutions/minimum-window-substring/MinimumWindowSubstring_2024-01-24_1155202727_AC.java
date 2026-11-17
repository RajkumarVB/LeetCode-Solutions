class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> window = new HashMap<>();
        HashMap<Character,Integer> countT = new HashMap<>(); 
        
        for(char c : t.toCharArray()){
            int count = countT.getOrDefault(c,0);
            countT.put(c,count+1); 
        }

        int have =0; 
        int need = countT.size(); 
        int resLen = Integer.MAX_VALUE; 
        int resL = -1, resR = -1; 
        int i = 0; 
        for(int j=0; j<s.length(); j++){
            char cj = s.charAt(j); 
            window.put(cj,window.getOrDefault(cj,0)+1); 
            if(countT.containsKey(cj) && window.get(cj).equals(countT.get(cj))) have ++; 
            
            while(have == need){
                if(j-i+1 < resLen){
                    resL = i; resR = j; 
                    resLen = j-i+1; 
                }
                char ci = s.charAt(i); 
                window.put(ci, window.getOrDefault(ci,0)-1); 
                if(countT.containsKey(ci) && window.get(ci) < countT.get(ci)) have --; 
                i++; 
            }
        }
        return (resLen != Integer.MAX_VALUE ) ? s.substring(resL, resR+1) : ""; 
    }
}