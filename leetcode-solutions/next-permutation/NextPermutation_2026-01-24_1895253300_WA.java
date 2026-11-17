class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length; 
        int breakingPoint = -1; 
        
        for(int i=n-2; i>=0 ;i--){
            if(nums[i] < nums[i+1]){
                breakingPoint = i ; 
                break; 
            }
        }
        
        if(breakingPoint == -1){
            // arrays is sorted in descending order 
            reverse(nums, 0 , n-1);
            return; 
        }

        // you found the breakingPoint 
        swap(nums, n-1, breakingPoint); 
        reverse(nums, breakingPoint+1, n-1); 


    }

    private void reverse(int[] nums, int i, int j){
        // swap in that range only 
        // assuming i and j are in bounds

        int left = i; 
        int right = j; 
        while(left < right){
            swap(nums, left, right);
            left ++ ;
            right --; 
        }

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }
}