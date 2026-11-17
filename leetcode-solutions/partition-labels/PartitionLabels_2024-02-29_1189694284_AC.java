class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>(); 
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1); 
        }
        HashSet<Character> seenChars = new HashSet<>();
        int splitCount =0; 
        List<Integer> result = new LinkedList<>(); 
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) -1);
            seenChars.add(c);
            splitCount ++; 
            boolean seenCharsCount = false; 
            for(char sc : seenChars){
                if(map.get(sc) != 0){
                    seenCharsCount = true; 
                    break; 
                }
            }
            if(!seenCharsCount){
                result.add(splitCount); 
                splitCount =0; 
                seenChars.clear(); 
            }
        }
        return result; 
    }
}

//ababcbacadefegdehijhklij
// ababcbaca defegde hijhklij