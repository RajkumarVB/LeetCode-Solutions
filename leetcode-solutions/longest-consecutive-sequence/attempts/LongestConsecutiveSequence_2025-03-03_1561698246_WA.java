class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums){
            set.add(ele); 
        }
        HashSet<Integer> dummySet = new HashSet<>(set);
        int ans = Integer.MIN_VALUE; 
        for(int ele : dummySet){
            int startingPoint = ele ;
            while(set.contains(ele -1)){
                startingPoint = ele -1; 
            }
            int count = 0; 
            while(set.contains(startingPoint)){
                count ++ ;
                set.remove(startingPoint);
                startingPoint++;
            }
            ans = Math.max(ans, count); 
        }
        return ans; 
    }
}