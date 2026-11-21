import java.util.*; 
class TimeMap {
    private HashMap<Pair,String> timeMap; 
    public TimeMap() {
        timeMap = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        Pair mapkey = new Pair(key,timestamp); 
        if(!timeMap.containsKey(mapkey)){
            timeMap.put(mapkey,value);
        }
    }
    
    public String get(String key, int timestamp) {
        Map.Entry<Pair,String> ans = null; 
        for(Map.Entry<Pair,String> entry : timeMap.entrySet()){
            if(entry.getKey().strKey.equals(key) && entry.getKey().timestampKey <= timestamp){
                if(ans == null || ans.getKey().timestampKey <= entry.getKey().timestampKey ){
                    ans = entry; 
                }
            }
        }
        return (ans == null) ? "" : ans.getValue(); 

    }

    record Pair(String strKey, int timestampKey){

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

 // foo,1 -> bar
 // foo,4 -> bar2 
 // get(foo,1) -> bar
 // get(foo,3) -> bar
 // get(foo,4) -> bar2
 // get(foo,5) -> bar2