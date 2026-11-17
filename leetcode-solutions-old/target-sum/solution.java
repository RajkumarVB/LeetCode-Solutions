class Solution {
    HashMap<Pair,Integer> map = new HashMap<>(); 
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return findWays(n-1,0, nums, target); 
    }
    public int findWays(int i, int sum, int[] nums, int target){
        if(i < 0){
            if(target == sum) return 1; 
            return 0; 
        }
        Pair p = new Pair(i,sum); 
        if(map.containsKey(p)) return map.get(p); 

        int pos = findWays(i-1,sum+nums[i], nums, target);
        int neg = findWays(i-1,sum-nums[i], nums, target);
        
        map.put(p, pos+neg); 
        return pos + neg; 
    }
    record Pair(int i, int sum){

    }
}