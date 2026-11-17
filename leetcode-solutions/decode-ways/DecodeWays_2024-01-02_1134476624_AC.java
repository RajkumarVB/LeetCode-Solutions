class Solution {
    String s ;
    int n;
    HashMap<Integer,Integer> memoMap = new HashMap<>(); 
    public int numDecodings(String s) {
        this.s = s;
        this.n = s.length();
        return numDecodings(0);
    }

    public int numDecodings(int pos) {
        if(pos >=n) return 1;
        if(s.charAt(pos) == '0') return 0;
        if(pos == n-1) return 1;
        if(memoMap.containsKey(pos)) return memoMap.get(pos);
        char firstChar = s.charAt(pos);
        char secondChar = s.charAt(pos+1);

        int ans1 = numDecodings(pos+1);

        int ans2 =0;
        if((firstChar == '1' && secondChar >= '0' && secondChar <= '9') ||(firstChar == '2' && secondChar >= '0' && secondChar <= '6')) {
                ans2 = numDecodings(pos+2);
        }
        memoMap.put(pos,ans1+ans2); 
        return ans1 + ans2 ;
    }
}