class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        int n = nums.length; 
        int sum = 0, result = 0; 
        prefixSum.put(0,1);
        for(int i=0; i<n;i++){
            sum += nums[i];
            result += prefixSum.getOrDefault(sum-k,0);
            prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);
        }
        return result;
    }
}