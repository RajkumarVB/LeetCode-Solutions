class Solution {
    int[] nums; 
    int n; 
    HashMap<Integer, Boolean> memoMap= new HashMap<>(); 
    public boolean canJump(int[] nums) {
        this.nums = nums; 
        this.n = nums.length; 
        return solve(0); 
    }
    public boolean solve(int currPosition){
        if(currPosition >= n-1) return true;
        if(memoMap.containsKey(currPosition)) return memoMap.get(currPosition); 
        int maxJumpLength = nums[currPosition]; 
        for(int i=1; i<=maxJumpLength; i++){
            if(solve(currPosition+i)){
                memoMap.put(currPosition, true); 
                return true; 
            } 
        }
        memoMap.put(currPosition, false); 
        return false; 
    }
}