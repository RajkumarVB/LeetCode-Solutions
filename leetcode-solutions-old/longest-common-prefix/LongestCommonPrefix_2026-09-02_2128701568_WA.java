class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length <= 1) return "";
        int minLength = Integer.MAX_VALUE; 
        for(String str : strs){
            minLength = Math.min(str.length(), minLength);
        }
        StringBuilder str = new StringBuilder();
        for(int i=0; i<minLength; i++){
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length; j++){
                if(c != strs[j].charAt(i)){
                    return str.toString();
                }
            }
            str.append(c); 
        }
        return str.toString();
    }
}