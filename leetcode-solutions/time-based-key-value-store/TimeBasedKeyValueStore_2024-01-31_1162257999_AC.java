class TimeMap {
    HashMap<String,List<Pair>> timeMap;
    public TimeMap() {
        this.timeMap = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key, new ArrayList<>()); 
        } 
        timeMap.get(key).add(new Pair(value,timestamp)); 
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) return ""; 
        String ans = ""; 
        List<Pair> list = timeMap.get(key); 
        int n = list.size(); 
        int low = 0, high = n-1; 
        while(low <= high){
            int mid = low + (high - low)/2; 
            Pair p = list.get(mid);
            if(p.time <= timestamp){
                ans = p.value; 
                low = mid +1; 
            } else {
                high = mid -1; 
            }
        }
        return ans; 
    }
    record Pair(String value, int time){

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */