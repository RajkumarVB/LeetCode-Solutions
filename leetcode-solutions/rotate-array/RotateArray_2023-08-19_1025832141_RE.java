class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length; 
        reverse(nums,0,n-1);
        // printArray(nums);
        reverse(nums,0,k-1);
        // printArray(nums);
        reverse(nums,k,n-1);
        // printArray(nums);
    }

    public static void printArray(int []nums){
        for(int element : nums) System.out.print(element + " ");
        System.out.println();
    }
    public static void reverse(int []nums, int left, int right){
        int n = nums.length; 
        if(n ==0 || n==1) return; 
        while(left < right){
            swap(nums,left,right);
            left++ ; 
            right-- ; 
        }
    }
    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left]= nums[right];
        nums[right] = temp; 
    }
}

// 1 2 3 4 5 6 7 

// 7 1 2 3 4 5 6
// 6 7 1 2 3 4 5 
// 5 6 7 1 2 3 4  


// 5 6 7 1 2 3 4  
// 7 6 5 4 3 2 1
// 5 6 7 1 2 3 4 