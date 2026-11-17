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