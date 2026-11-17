class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] tempAns = nextGreaterElement(nums2); 
        HashMap<Integer,Integer> map = new HashMap<>(); 
        for(int i=0; i<nums2.length; i++){
            map.put(nums2[i], i); 
        }
        int[] ans = new int[nums1.length]; 
        for(int i=0; i<nums1.length; i++){
            ans[i] = tempAns[map.get(nums1[i])]; 
        }
        return ans; 
    }
    private int[] nextGreaterElement(int[] nums){
        int n = nums.length; 
        if(n == 1) return new int[]{-1}; 


        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>(); 
        ans[n-1] = -1; 
        stack.addLast(nums[n-1]); 


        for(int i=n-2; i>=0; i--){
            while(!stack.isEmpty() && stack.getLast() < nums[i]){
                stack.removeLast(); 
            }
            if(stack.isEmpty()){
                ans[i] = -1; 
            }else{
                ans[i] = stack.getLast(); 
            }
            stack.addLast(nums[i]); 
        }
        return ans; 
    }
}
