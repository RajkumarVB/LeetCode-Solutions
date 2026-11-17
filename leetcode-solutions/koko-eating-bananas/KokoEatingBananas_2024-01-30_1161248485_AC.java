class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBannanas = Integer.MIN_VALUE; 
        for(int bannanas : piles) maxBannanas = Math.max(maxBannanas,bannanas); 
        int low = 1, high = maxBannanas; 
        int ans = high; 
        while(low <= high){
            int es = low + (high - low)/2;
            if(isEatable(piles,es,h)){
                ans = es; 
                high = es -1; 
            } else {
                low = es + 1; 
            }
        }
        return ans ;
    }
    public boolean isEatable(int[] piles, int es, int h) {
        int actualH = 0; 
        for (int bananas : piles) {
            actualH +=  Math.ceil(((double)bananas) / es) ; 
        }
        return actualH <= h; 
    }
}