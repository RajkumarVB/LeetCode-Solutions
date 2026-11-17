class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String s : strs){
            char[] keyChars = s.toCharArray();
            Arrays.sort(keyChars);
            String key = String.valueOf(keyChars);
            if(!groups.containsKey(key)){
                groups.put(key, new LinkedList<>());
            }
            groups.get(key).add(s);
        }
        return new LinkedList<>(groups.values());
    }
}

// ["nat","tan"]

// ant -> nat tan 


// ["ate","eat","tea"]

// aet -> ate, eat, tea