class Solution {
    public String countAndSay(int n) {
        if(n ==1) return "1"; 
        String tempAns = countAndSay(n-1);
        return say(tempAns); 
    }

    public String say(String s){
        if(s == null || s.length() ==0) return ""; 
        
        int n = s.length(); 
        int i=0, j=0, count = 0; 

        StringBuilder ans = new StringBuilder(); 
        while(j < n){
            if(s.charAt(i) == s.charAt(j)){
                count ++; 
                j++; 
            } else {
                char charCount = (char) ('0' + count); 
                ans.append(charCount); 
                ans.append(s.charAt(i));  
                
                i = j; 
                count = 0; 
            }
        }
        char charCount = (char) ('0' + count); 
        ans.append(charCount); 
        ans.append(s.charAt(i));  

        return ans.toString(); 
    }
}