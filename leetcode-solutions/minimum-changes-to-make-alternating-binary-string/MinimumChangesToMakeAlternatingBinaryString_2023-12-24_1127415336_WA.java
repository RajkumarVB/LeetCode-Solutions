class Solution {
    public int minOperations(String s) {
        HashMap<Character,Character> complementMap = new HashMap<>(); 
        initializeMap(complementMap);

        char expectedChar = s.charAt(0); 
        int n = s.length(); 
        int result =0; 

        for(int i=1; i<n; i++){
           char currentChar = s.charAt(i);
           if(complementMap.get(currentChar) != expectedChar){
               result++; 
           }

           expectedChar = complementMap.get(expectedChar); 
        }
        return result; 

    }
    public static void initializeMap(HashMap<Character,Character> complementMap){
        complementMap.put('0','1');
        complementMap.put('1','0');
    }
}