class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> positives = new ArrayList<>(); 
        ArrayList<Integer> negatives = new ArrayList<>();
        int n = nums.length; 
        for(int element : nums){
            if(element < 0){
                negatives.add(element);
            } else{
                positives.add(element);
            }
        }
        int[] res = new int[n];
        for(int i=0; i<n/2 ;i++){
            res[i*2] = positives.get(i);
            res[i*2 + 1] = negatives.get(i);
        }
        return res; 
    }
}