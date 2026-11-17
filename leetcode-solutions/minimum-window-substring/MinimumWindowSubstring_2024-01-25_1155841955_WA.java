class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> countT = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        int n = s.length();
        int m = s.length();

        for(char c : t.toCharArray()){
            countT.put(c,countT.getOrDefault(c,0)+1); 
        }
        int have =0, need = countT.size(), i =0, j = 0; 
        int resLen = Integer.MAX_VALUE, resL = -1, resR =-1 ; 
        while(j < n){
            char cj = s.charAt(j); 
            window.put(cj,window.getOrDefault(cj,0) + 1); 
            
            if(countT.containsKey(cj) && Integer.valueOf(countT.get(cj)) == Integer.valueOf(window.get(cj))){
                have ++; 
            }
            while(have == need){
                if(j -i +1 < resLen){
                    resLen = j-i +1; 
                    resL = i; 
                    resR = j; 
                }
                char ci = s.charAt(i);
                window.put(ci,window.getOrDefault(ci,0) - 1); 
                if(countT.containsKey(ci) && window.get(ci) < countT.get(ci)){
                    have --; 
                }
                i++; 
            }
            j++; 
        }
        return (resLen != Integer.MAX_VALUE ) ? s.substring(resL, resR +1) : ""; 
    }
}