class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> map = new HashMap<>(); 
        for(int ele : hand){
            int count = map.getOrDefault(ele,0);
            map.put(ele, count+1); 
        }
        PriorityQueue<Integer> mHeap = new PriorityQueue(map.keySet()); 
        while(!mHeap.isEmpty()){
            int first = mHeap.peek(); 
            for(int i = first; i < first+groupSize ; i++){
                if(!map.containsKey(i)) return false; 
                int count = map.get(i); 
                map.put(i,count -1); 
                if(map.get(i) ==0){
                    if(i != mHeap.peek()) return false; 
                    mHeap.poll(); 
                }
            }
        }
        return true; 
    }
}