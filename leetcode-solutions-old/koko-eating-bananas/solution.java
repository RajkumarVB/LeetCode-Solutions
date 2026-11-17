class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = findMax(piles); 
        int left = 1, right = maxPile; 
        int result = maxPile; 
        while(left <= right){
            int mid = (right - left) / 2 + left; 
            if(canEatAtGivenSpeed(mid, piles, h)){
                result = Math.min(result,mid); 
                right = mid -1 ;
            }else{
                left = mid + 1; 
            }
        }
        return result; 
    }

    private boolean canEatAtGivenSpeed(int speed, int[] piles, int h){
        double totalHours = 0; 
        for(int pile : piles){
            int hour = (int) Math.ceil((double) pile / speed); 
            totalHours += hour; 
        }
        return totalHours <= h; 
    }
    private int findMax(int[] piles){
        int max = piles[0];
        for(int pile : piles){
            max = Math.max(max, pile);
        }
        return max; 
    }
}