class Solution {
    public void rotate(int[] nums, int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        int n = nums.length; 
        k = k%n;
        for(int i = n-k ; i<n ;i++){
            temp.add(nums[i]);
        }
        for(int i = n-1 ; i>=k ; i--){
            nums[i] = nums[i-k]; 
        }
        int x = 0 ;
        for(int i =0; i<k; i++,x++){
            nums[i] = temp.get(x); 
        }
    }
}