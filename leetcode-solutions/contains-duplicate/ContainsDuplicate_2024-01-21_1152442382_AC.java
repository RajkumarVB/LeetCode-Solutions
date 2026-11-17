class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length; 
        for(int i=0; i<n; i++){
            int num = nums[i]; 
            if(set.contains(num)) return true; 
            set.add(num);
        }
        return false; 
    }
}