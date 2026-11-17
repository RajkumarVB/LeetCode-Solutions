class Solution {
    private List<String> ans = new LinkedList<>(); 
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new LinkedList<>(); 
        HashMap<Integer, String> lettersToPhoneNumberMap = new HashMap<>(); 
        lettersToPhoneNumberMap.put(2,"abc");
        lettersToPhoneNumberMap.put(3,"def");
        lettersToPhoneNumberMap.put(4,"ghi");
        lettersToPhoneNumberMap.put(5,"jkl");
        lettersToPhoneNumberMap.put(6,"mno");
        lettersToPhoneNumberMap.put(7,"pqrs");
        lettersToPhoneNumberMap.put(8,"tuv");
        lettersToPhoneNumberMap.put(9,"wxyz");

        computeLetterCombinations(digits, 0, new StringBuilder(),lettersToPhoneNumberMap); 
        return ans; 
    }

    private void computeLetterCombinations(String digits, int i, StringBuilder tempAns, HashMap<Integer, String> lettersToPhoneNumberMap){
        if(i == digits.length()){
            ans.add(tempAns.toString()); 
            return; 
        }

        int digit = (int) (digits.charAt(i) - '0');
        String letters = lettersToPhoneNumberMap.get(digit); 
        for(int k=0; k<letters.length(); k++){
            tempAns.append(letters.charAt(k)); 
            computeLetterCombinations(digits, i+1, tempAns, lettersToPhoneNumberMap); 
            tempAns.deleteCharAt(tempAns.length() -1); 
        }
    }
}