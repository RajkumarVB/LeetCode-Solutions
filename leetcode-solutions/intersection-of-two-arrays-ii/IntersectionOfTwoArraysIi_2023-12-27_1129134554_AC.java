class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> countMap1 = new HashMap<>(); 
        HashMap<Integer,Integer> countMap2 = new HashMap<>();
       
        for(int i : nums1){
            int count = countMap1.getOrDefault(i,0);
            countMap1.put(i, count+1); 
        }
        for(int i : nums2){
            int count = countMap2.getOrDefault(i,0);
            countMap2.put(i, count+1); 
        }
        System.out.println(countMap1);
        System.out.println(countMap2);

        int n = nums1.length; 
        int m = nums2.length; 

        List<Integer> result = new LinkedList<>(); 

        if(n < m){
            for(int i : nums1){
                int count1 = countMap1.getOrDefault(i,0);
                int count2 = countMap2.getOrDefault(i,0); 

                if(count1 != 0) countMap1.put(i,count1-1);
                if(count2 != 0) countMap2.put(i,count2-1);
                
                int resultCount = Math.min(count1, count2);
                if(resultCount > 0 ) result.add(i);
            }
        } else {
            for(int i : nums2){
                int count1 = countMap1.getOrDefault(i,0);
                int count2 = countMap2.getOrDefault(i,0); 

                if(count1 != 0) countMap1.put(i,count1-1);
                if(count2 != 0) countMap2.put(i,count2-1);
                
                int resultCount = Math.min(count1, count2);
                if(resultCount > 0 ) result.add(i);
            }
        }

        int[] ans = new int[result.size()]; 
        for(int i=0; i<result.size(); i++){
            ans[i] = result.get(i); 
        }
        return ans; 
    }
}