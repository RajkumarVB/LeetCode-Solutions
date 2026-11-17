class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = findMax(piles); 
        
    }
    private int findMax(int[] piles){
        int max = piles[0];
        for(int pile : piles){
            max = Math.max(max, pile);
        }
        return max; 
    }
}