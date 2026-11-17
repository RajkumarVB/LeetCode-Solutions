class Solution {
    private HashMap<Character,Character> complementMap = new HashMap<>(); 
    public int minOperations(String s) {
        this.initializeMap();

        char firstChar =s.charAt(0); 

        int count1 = this.calcMinOperations(s,firstChar);
        int count2 = this.calcMinOperations(s,complementMap.get(firstChar)) + 1;
        return Math.min(count1, count2);

    }
    public void initializeMap(){
        complementMap.put('0','1');
        complementMap.put('1','0');
    }

    public int calcMinOperations(String s, char lastChar){
        int n = s.length(); 
        int result =0; 

        for(int i=1; i<n; i++){
           char currentChar = s.charAt(i);
           if(complementMap.get(currentChar) != lastChar){
               result++; 
           }

           lastChar = complementMap.get(lastChar); 
        }
        return result; 
    }
}