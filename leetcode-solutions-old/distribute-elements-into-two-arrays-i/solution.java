class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new LinkedList<>();
        List<Integer> arr2 = new LinkedList<>();
        int n = nums.length; 
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i=2; i<n; i++){
            if(arr1.getLast() > arr2.getLast()){
                arr1.add(nums[i]);
            }else{
                arr2.add(nums[i]);
            }
        }
        arr1.addAll(arr2);
        int[] result = new int[n];
        for(int i =0; i<n; i++){
            result[i] = arr1.get(i);
        }
        return result; 
    }
}