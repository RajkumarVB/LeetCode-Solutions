class Solution {
    private List<String> ans; 
    public List<String> generateParenthesis(int n) {
        this.ans = new LinkedList<>(); 
        solve(0,0,n, new StringBuilder()); 
        return ans; 
    }
    public void solve(int openUsed, int closedUsed, int n, StringBuilder tempAns){
        if(openUsed == n && closedUsed == n){
            ans.add(tempAns.toString());
        }
        if(openUsed < n){
            tempAns.append('(');
            solve(openUsed+1, closedUsed,n, tempAns);
            tempAns.deleteCharAt(tempAns.length() - 1); 
        }
        if(openUsed > closedUsed){
            tempAns.append(')');
            solve(openUsed, closedUsed+1,n, tempAns);
            tempAns.deleteCharAt(tempAns.length() - 1); 
        }
    }
}