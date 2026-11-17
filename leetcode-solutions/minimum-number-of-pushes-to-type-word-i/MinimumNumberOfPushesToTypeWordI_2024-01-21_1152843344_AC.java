class Solution {
    public int minimumPushes(String word) {
        int n = word.length(); 
        ArrayList<Integer> charCount = new ArrayList<>();
        for(int i=0; i<26; i++) charCount.add(0); 
        for(char c : word.toCharArray()){
            int count = charCount.get(c-'a') ; 
            charCount.set(c-'a',count+1); 
        }
        charCount.sort((a,b) -> b-a); 
        for(int count : charCount) System.out.print(count + " ");
        int result = 0; 
        int pos =1; 
        for(int i=0; i<26; i+=8){
            for(int j = i;j<n && j <i+8; j++){
                result += charCount.get(j) * pos; 
            }
            pos ++; 
        }
        return result; 
    }
}