class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>(); 
        for(int i=1; i<= numRows; i++){
            List<Integer> row = generateRow(i);
            result.add(row); 
        }
        return result; 
    }
    public static List<Integer> generateRow(int row){
        List<Integer> ans = new LinkedList<>(); 
        int val = 1;

        ans.add(val); 

        for(int i=1; i<row; i++){
            val *= (row - i);
            val /= i; 
            ans.add(val); 
        }

        return ans; 
    }
}