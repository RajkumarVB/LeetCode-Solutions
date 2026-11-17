class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       if(strs.length == 0) return new LinkedList<>(); 
       HashMap<String, List<String>> ans = new HashMap<>(); 
       for(String s : strs){
            char[] chars = s.toCharArray(); 
            Arrays.sort(chars); 
            String key = String.valueOf(chars); 
            if(!ans.containsKey(key)){
                ans.put(key, new LinkedList<>()); 
            }
            ans.get(key).add(s); 
       }
       return new LinkedList<>(ans.values()); 
    }
}