class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length; 
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(var element : nums){
            int count = hashMap.getOrDefault(element,0);
            hashMap.put(element, count+1);
        }
        // for(var element : hashMap.entrySet()){
        //     System.out.print(element.getKey() +"->" + element.getValue());
        //     System.out.println();
        // }
        for(var item : hashMap.entrySet()){
            if(item.getValue() ==1){
                return item.getKey();
            }
        }
        return -1;
    }
}