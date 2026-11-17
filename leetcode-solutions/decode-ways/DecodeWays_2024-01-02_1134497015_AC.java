class Solution {
    private String s ; 
    private int n; 
    HashMap<Integer, Integer> memoMap = new HashMap<>(); 
    public int numDecodings(String s) {
        this.s = s; 
        this.n = s.length(); 
        return numDecodings(0); 
    }
    public int numDecodings(int pos) {
        this.s = s; 
        this.n = s.length(); 
        if(pos >= n) return 1; 
        if(s.charAt(pos) == '0') return 0; 
        if(pos == n-1) return 1; 
        
        if(memoMap.containsKey(pos)){
            return memoMap.get(pos); 
        }
        int result1 = numDecodings(pos + 1); 
        int result2 = 0; 
        int result = 0; 
        
        char firstChar = s.charAt(pos);
        char secondChar = s.charAt(pos + 1);

        if(firstChar =='1' && (secondChar >= '0' && secondChar <='9') || 
          firstChar =='2' && (secondChar >= '0' && secondChar <='6')){
            result2 = numDecodings(pos + 2); 
        }

        result = result1 + result2; 
        memoMap.put(pos, result); 

        return result; 
    }
}