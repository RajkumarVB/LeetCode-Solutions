class Solution {
    private String s; 
    private int n; 
    private List<List<String>> ans = new LinkedList<>(); 
    
    public List<List<String>> partition(String s) {
        this.s = s; 
        this.n = this.s.length(); 
        solve(new LinkedList<>(), 0); 
        return ans; 
    }

    
    public void solve(List<String>tempAns, int index){
        if(index >= n){
            ans.add(new LinkedList<>(tempAns)); 
            return; 
        }

        for(int i=index; i<n; i++){
            if(isPalindrome(index,i)){
                tempAns.add(s.substring(index,i+1)); 
                solve(tempAns,i+1); 
                tempAns.remove(tempAns.size()-1); 
            }
        }
    }

    public boolean isPalindrome(int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false; 
            i++;
            j--; 
        }
        return true; 
    }
}