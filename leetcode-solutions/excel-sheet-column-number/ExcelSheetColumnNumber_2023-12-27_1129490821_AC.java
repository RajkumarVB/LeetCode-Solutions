class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length(); 
        int result = 0; 
        int pow = 0; 
        for(int i=n-1; i>=0; i--){
            int value = getValue(columnTitle.charAt(i));
            result += (value * Math.pow(26, pow)); 
            pow ++; 
        }
        return result; 
    }
    public static int getValue(char c){
        return (c - 'A' + 1) ;
    }
}