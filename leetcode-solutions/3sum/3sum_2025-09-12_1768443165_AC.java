class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // [-1,0,1,2,-1,-4]
        // -4 -1 -1 0 1 2
        HashSet<List<Integer>> result = new HashSet<>(); 
        Arrays.sort(nums); 
        int n = nums.length; 
        for(int i=0; i<n; i++){
            
            int left = i+1, right = n-1; 
            while(left < right){
                
                int currentSum = nums[left] + nums[right] + nums[i] ;
                // System.out.println(currentSum);
                if(currentSum == 0){
                    List<Integer> tempResult = new LinkedList<>(); 
                    tempResult.add(nums[left]);
                    tempResult.add(nums[right]);
                    tempResult.add(nums[i]);
                    Collections.sort(tempResult);
                    result.add(tempResult); 
                    left ++; 
                    right --; 
                }else if (currentSum > 0){
                    right --; 
                }else{
                    left ++; 
                }
            }
        }
        List<List<Integer>> finalResult = new LinkedList<>();
        for(var ele: result){
            finalResult.add(ele); 
        }
        return finalResult; 
    }
}