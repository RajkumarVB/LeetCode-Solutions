class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length; 
        HashSet<List<Integer>> ans = new HashSet<>(); 
        for(int i=0; i<n; i++){
            HashSet<Integer> seenSoFar = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int elementToLookFor = - (nums[i] + nums[j]); 
                if(seenSoFar.contains(elementToLookFor)){
                    List<Integer> tempAns = new LinkedList<>();
                    tempAns.add(nums[i]);
                    tempAns.add(nums[j]);
                    tempAns.add(elementToLookFor);

                    tempAns.sort(null); 
                    ans.add(tempAns); 
                }
                seenSoFar.add(nums[j]);
            }
        }
        return new LinkedList<>(ans); 
    }
}