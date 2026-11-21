class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length; 
        List<List<String>> ans = new ArrayList<>(); 
        boolean[] isTaken = new boolean[n]; 

        for(int i =0 ; i<n ; i++){
            if(!isTaken[i]){
                List<String> temp = new ArrayList<>(); 


                isTaken[i] = true;
                String s1 = strs[i]; 

                temp.add(s1); 
                for(int j = i+1; j<n ; j++){
                    if(isTaken[j] == false){
                        String s2 = strs[j]; 
                        if(isAnagram(s1,s2)){
                            isTaken[j] = true; 
                            temp.add(s2); 
                        }
                    }
                }
                ans.add(temp); 
            }
        }
        return ans; 
    }

    public boolean isAnagram(String s1, String s2){
        int n = s1.length();
        int m = s2.length(); 
        if(n != m) return false; 

        HashMap<Character, Integer> map = new HashMap<>(); 
        for(int i =0 ; i<n ; i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0) +1 ); 
        }

        for(int i =0 ; i<m ; i++){
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i),0) - 1 ); 
        }

        for(int value : map.values()){
            if(value != 0) return false ;
        }
        return true; 
    }
}