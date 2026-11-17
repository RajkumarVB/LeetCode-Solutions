class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>(); 
        
        for(char c : s.toCharArray()){
            int count = countMap.getOrDefault(c,0); 
            countMap.put(c,count+1); 
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i); 
            if(countMap.get(c) == 1) return i; 
        }
        return -1; 
    }
}