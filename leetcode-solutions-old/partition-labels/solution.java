class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastIndexMap = new HashMap<>(); 
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i); 
            lastIndexMap.put(c,i); 
        }
        int count =0, end = 0; 
        List<Integer> result = new LinkedList<>(); 
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i); 

            end = Math.max(end,lastIndexMap.get(c));
            count++; 
            if(end == i){
                result.add(count);
                count =0; 
            }
        }
        return result; 
    }
}