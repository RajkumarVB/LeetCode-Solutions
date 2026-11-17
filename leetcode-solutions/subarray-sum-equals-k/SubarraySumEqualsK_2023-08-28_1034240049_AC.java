class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prevSum = new HashMap<>();
        int sum = 0, result = 0; 
        int n = nums.length; 
        for(int i=0; i<n ;i++){
            sum += nums[i];
            if(sum ==k) result++;
            result += prevSum.getOrDefault(sum-k,0);
            prevSum.put(sum,prevSum.getOrDefault(sum,0)+1);
        }
        return result;
    }
}