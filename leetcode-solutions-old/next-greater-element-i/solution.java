class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> indexPosition = new HashMap<>(); 
        int[] result = new int[nums1.length]; 
        int[] nextGreaterElement = nextGreaterElement(nums2); 
        for(int i=0; i<nums2.length; i++){
            indexPosition.put(nums2[i], i); 
        }

        for(int i=0; i<nums1.length; i++){
            result[i] = nextGreaterElement[indexPosition.get(nums1[i])];
        }
        return result; 
    }
    private int[] nextGreaterElement(int[] nums){
        int n = nums.length; 
        LinkedList<Integer> stack = new LinkedList<>(); 
        int[] result = new int[n]; 
        Arrays.fill(result, -1); 
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[i] >= stack.getLast()){
                stack.removeLast(); 
            }
            if(!stack.isEmpty()){
                result[i] = stack.getLast(); 
            }
            stack.addLast(nums[i]); 
        }
        return result; 
    }
}