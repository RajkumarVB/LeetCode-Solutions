class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums); 
        int n = nums.length; 
        for(int i=0; i<n; i++){
            if( i!=0 && nums[i] == nums[i-1]) continue; 
            
            int left = i+1, right = n-1; 
            while(left < right){
                if(left != i+1 && nums[left] == nums[left-1]){
                    left ++; 
                    continue; 
                } 
                if(right != n-1 && nums[right] == nums[right+1]){
                    right --; 
                    continue; 
                }

                int currentSum = nums[left] + nums[right] + nums[i] ;
                if(currentSum == 0){
                    result.add(List.of(nums[i], nums[left], nums[right])); 
                    left ++; 
                    right --; 
                }else if (currentSum > 0){
                    right --; 
                }else{
                    left ++; 
                }
            }
        }
        return result; 
    }
}