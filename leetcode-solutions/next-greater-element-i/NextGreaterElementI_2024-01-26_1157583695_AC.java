class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length; 
        LinkedList<Integer> stack = new LinkedList<>(); 
        HashMap<Integer,Integer> nextGreater = new HashMap<>(); 
        List<Integer> result = new LinkedList<>(); 
        for(int i=n-1; i>= 0; i--){
            while(!stack.isEmpty() && stack.getLast() < nums2[i]){
                stack.removeLast(); 
            }
            if(!stack.isEmpty()){
                nextGreater.put(nums2[i], stack.getLast()); 
            } else {
                nextGreater.put(nums2[i], -1); 
            }
            stack.addLast(nums2[i]); 
        }
        for(int i=0; i<nums1.length; i++){
            result.add(nextGreater.get(nums1[i])); 
        }
        return result.stream().mapToInt(Integer::intValue).toArray(); 
    }
}