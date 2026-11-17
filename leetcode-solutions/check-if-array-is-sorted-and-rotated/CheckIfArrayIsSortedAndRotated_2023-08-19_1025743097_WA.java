class Solution {
    public boolean check(int[] nums) {
        // printArray(nums); 
        for(int i=0; i<nums.length -1; i++){
            if(isSorted(nums)) return true; 
            rightRotate(nums);
            // printArray(nums);
        }
        return false ; 
    }

    public static void printArray(int[] nums){
        for(int element : nums ){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void rightRotate(int[] nums){
        int n = nums.length; 
        int temp = nums[n-1];
        for(int i = n-1; i>0 ; i--){
            nums[i]= nums[i-1]; 
        }
        nums[0] = temp; 
    }

    public static boolean isSorted(int [] nums){
        for(int i=0;i<nums.length-1; i++ ){
            if(nums[i] > nums[i+1]) return false ; 
        }
        return true; 
    }
}

// [3,4,5,1,2] -> Before Rotation would be 1 2 3 4 5 
// [2,1,3,4] -> 4 2 1 3 -> 3 4 2 1 -> 4 2 1   
// [1,2,3] -> 

//[3,4,5,1,2] -> 2 3 4 5 1 -> 1 2 3 4 5 