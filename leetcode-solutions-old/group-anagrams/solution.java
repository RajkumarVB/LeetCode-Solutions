class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String s : strs){
            String key = Arrays.toString(computeFrequency(s));
            // System.out.println(key);

            if(!groups.containsKey(key)){
                groups.put(key, new LinkedList<>());
            }
            groups.get(key).add(s);
        }
        return new LinkedList<>(groups.values());
    }
    private int[] computeFrequency(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++; 
        }
        return freq; 
    }
}