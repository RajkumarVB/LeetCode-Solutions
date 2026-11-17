class Solution {
    private List<String> result; 
    public List<String> generateParenthesis(int n) {
        result = new LinkedList<>(); 
        generate(n, 0,0, new StringBuilder()); 
        return result; 
    }

    private void generate(int n, int openUsed , int closedUsed, StringBuilder tempResult){
        if(openUsed ==n && closedUsed ==n ){
            result.add(tempResult.toString()); 
            return; 
        }
        if(openUsed < n){
            tempResult.append('('); 
            generate(n, openUsed + 1, closedUsed,tempResult); 
            tempResult.deleteCharAt(tempResult.length()-1); 
        }
       

        if(closedUsed < openUsed){
            tempResult.append(')'); 
            generate(n, openUsed, closedUsed + 1,tempResult); 
            tempResult.deleteCharAt(tempResult.length()-1); 
        }
    }
}
