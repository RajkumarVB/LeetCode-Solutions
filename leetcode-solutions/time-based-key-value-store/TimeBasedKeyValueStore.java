/*
 * 981. Time Based Key-Value Store  [Medium]
 * https://leetcode.com/problems/time-based-key-value-store/
 * Topics: Hash Table, String, Binary Search, Design
 *
 * Problem:     Design set(key, value, timestamp) and get(key, timestamp), which returns the
 *              value with the largest timestamp <= the given one ("" if none).
 * Example:     set(foo,bar,1); get(foo,3) -> bar; set(foo,bar2,4); get(foo,4) -> bar2
 * Constraints: <= 2e5 calls, timestamps increase per key
 *
 * Key idea:    Map key -> list of (timestamp, value), already sorted because timestamps
 *              only increase. get is a binary search for the last timestamp <= t.
 *
 * Approach:    HashMap of lists + upper-bound binary search
 * Complexity:  time O(1) set, O(log n) get, space O(n)
 * Submitted:   2025-09-23 (submission 1780468365, AC)
 */

class TimeMap {
    private HashMap<String,List<Pair>> map; 
    public TimeMap() {
        this.map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>()); 
        }
        map.get(key).add(new Pair(value,timestamp)); 
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return ""; 
        String result = ""; 
        // instead of linear search, I can perform a binary search. 
        int left = 0, right = map.get(key).size() -1; 
        while(left <= right){
            int mid = (right - left) / 2 + left; 
            Pair p = map.get(key).get(mid); 
            if(p.timestamp <= timestamp){
                result = p.value; 
                left = mid + 1; 
            }else{
                right = mid -1; 
            }
        }
        return result; 
    }

    record Pair(String value, int timestamp){

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */