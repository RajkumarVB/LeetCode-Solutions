class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prevSum = new HashMap<>();
        int n = nums.length; 
        int sum =0, result =0 ; 
        prevSum.put(0,1);
        for(int i=0; i<n ;i++){
            sum += nums[i];
            result += prevSum.getOrDefault(sum-k,0);
            prevSum.put(sum,prevSum.getOrDefault(sum,0)+1);
        }
        return result; 
    }
}