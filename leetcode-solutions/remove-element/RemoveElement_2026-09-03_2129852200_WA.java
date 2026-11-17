class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length; 
        int i=0, j=n-1; 

        int count = 0; 
        while(j >=0 ){
            if(nums[j] == val){
                count ++; 
                j--; 
            }else{
                break;
            }
        }
        while(i <= j){
            if(nums[i] == val){
                count++; 
                swap(nums, i, j);
                j--;
            }
            i++; 
        }
        return n - count; 
    }

    private void swap(int[] nums, int i, int j){
        int temp; 
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }
}