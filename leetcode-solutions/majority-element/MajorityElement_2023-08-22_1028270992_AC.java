class Solution {
    public int majorityElement(int[] nums) {
        int count = 0 ; 
        int res = Integer.MIN_VALUE ;
        for(int element : nums){
            if(count ==0){
                count++;
                res = element; 
            } else if (element == res){
                count++;
            } else {
                count --; 
            }
        }
        return res; 
    }
}