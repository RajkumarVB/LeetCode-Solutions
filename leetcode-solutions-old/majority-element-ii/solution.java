class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 =0, count2 =0;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(count1 == 0 && nums[i] != element2){
                element1 = nums[i];
                count1 =1;
            } else if(count2 ==0 && nums[i] != element1){
                element2 = nums[i];
                count2 =1;
            } else if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2 ++;
            } else{
                count1 --;
                count2 --;
            }
        }
        count1 = count2 = 0;
        for(int element : nums){
            if(element == element1) count1 ++; 
            else if (element == element2) count2 ++; 
        }
        
        if(count1> n/3) ans.add(element1);
        if(count2> n/3) ans.add(element2);
        
        return ans; 
    }
}