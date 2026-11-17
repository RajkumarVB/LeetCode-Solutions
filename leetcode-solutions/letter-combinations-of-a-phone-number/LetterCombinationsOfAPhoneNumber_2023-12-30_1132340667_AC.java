class Solution {
    private HashMap<Character, String> map = new HashMap<>(); 
    private List<String> ans = new LinkedList<>(); 
    private String digits; 

    public Solution(){
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if(digits.isEmpty()) return new LinkedList<>();
        backtrack(0, new StringBuilder());
        return ans;
    }

    public void backtrack(int i, StringBuilder tempAns){
        if(tempAns.length() == digits.length()){
            ans.add(tempAns.toString());
            return;
        }

        for(int k=0; k<map.get(digits.charAt(i)).length(); k++){
            char c = map.get(digits.charAt(i)).charAt(k);
            tempAns.append(c);
            backtrack(i+1, tempAns);
            tempAns.deleteCharAt(tempAns.length() - 1);
        }
    }
}