class Solution {
    public int compress(char[] chars) {
        int n = chars.length; 
        int toAddIdx = 0 ; 
        int i = 0; 
        while(i < n){
            char c = chars[i]; 
            int count = 0; 
            while(i<n && chars[i] == c){
                count ++; 
                i ++; 
            }
            chars[toAddIdx] = c; 
            toAddIdx++; 
            if(count > 1){
                String countStr = String.valueOf(count); 
                for(char countC : countStr.toCharArray()){
                    chars[toAddIdx] = countC;
                    toAddIdx++; 
                }
            }
        }
        return toAddIdx; 
    }
}