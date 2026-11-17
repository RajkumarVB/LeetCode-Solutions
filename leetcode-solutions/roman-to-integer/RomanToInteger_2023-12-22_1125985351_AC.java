class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> exceptionMap = new HashMap<>(); 
        initializeExceptionMap(exceptionMap); 

        if(exceptionMap.containsKey(s)) return exceptionMap.get(s); 

        HashMap<Character, Integer> valueMap = new HashMap<>(); 
        initializeValueMap(valueMap); 

        int result = 0; 
        int i = 0; 
        while(i < s.length() -1 ){
            if(exceptionMap.containsKey(s.substring(i,i+2))){
                result += exceptionMap.get(s.substring(i,i+2)); 
                i += 2; 
            } else{
                result += valueMap.get(s.charAt(i)); 
                i++; 
            }
        }
        if(i == s.length() -1) result += valueMap.get(s.charAt(i)); 
        return result ;  
    }

    public static void initializeExceptionMap(HashMap<String, Integer> exceptionMap){
        exceptionMap.put("IV", 4);
        exceptionMap.put("IX", 9);
        exceptionMap.put("XL", 40);
        exceptionMap.put("XC", 90);
        exceptionMap.put("CD", 400);
        exceptionMap.put("CM", 900);
    }

    public static void initializeValueMap(HashMap<Character, Integer> valueMap){
        valueMap.put('I',1);
        valueMap.put('V',5);
        valueMap.put('X',10);
        valueMap.put('L',50);
        valueMap.put('C',100);
        valueMap.put('D',500);
        valueMap.put('M',1000);
    }
}