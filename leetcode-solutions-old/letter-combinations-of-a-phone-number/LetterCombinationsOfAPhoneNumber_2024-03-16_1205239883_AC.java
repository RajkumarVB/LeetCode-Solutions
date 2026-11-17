class Solution {
    
    HashMap<Character, String> map = new HashMap<>();
    String digits; 
    List<String> result = new LinkedList<>(); 
    int n; 

    public List<String> letterCombinations(String digits) {
        initializeMap(map); 
        this.digits = digits; 
        this.n = digits.length();
        if(n == 0) return new LinkedList<>(); 
        bactrack(0, new StringBuilder()); 
        return result;  
    }
    public void bactrack(int i, StringBuilder tempResult){
        if(i == n){
            result.add(tempResult.toString());
            return ; 
        }
        for(char c : map.get(digits.charAt(i)).toCharArray()){
            tempResult.append(c); 
            bactrack(i+1,tempResult);
            tempResult.deleteCharAt(tempResult.length()-1); 
        }
    }
    
    public void initializeMap(HashMap<Character, String> map){
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
}