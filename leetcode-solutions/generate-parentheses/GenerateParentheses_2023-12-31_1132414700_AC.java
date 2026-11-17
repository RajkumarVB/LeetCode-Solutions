class Solution {
    private List<String> ans = new LinkedList<>();
    private int n ;

    public List<String> generateParenthesis(int n) {
        this.n = n; 
        solve(0,0, new StringBuilder()); 
        return ans; 
    }
    
    public void solve(int openUsed, int closedUsed, StringBuilder tempAns){
        if(openUsed == n && closedUsed == n){
           ans.add(tempAns.toString()); 
           return; 
        }

        if(openUsed < n){
            tempAns = tempAns.append('(');
            solve(openUsed +1, closedUsed, tempAns);
            tempAns.deleteCharAt(tempAns.length() -1); 
        }

        if(closedUsed < openUsed){
            tempAns = tempAns.append(')'); 
            solve(openUsed, closedUsed + 1, tempAns);
            tempAns.deleteCharAt(tempAns.length() -1); 
        }
    }
}