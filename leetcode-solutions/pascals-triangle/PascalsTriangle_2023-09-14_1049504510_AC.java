class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result= new ArrayList<>();
        for(int i=1 ;i<=numRows; i++){
            result.add(generateRow(i));
        }
        return result; 
    }
    List<Integer> generateRow(int row){
        List<Integer> result = new ArrayList<>();
        result.add(1);
        long element = 1;
        for(int i=1;i<row;i++){
            element *= (row - i);
            element /= i;
            result.add((int)element);
        }
        return result; 
    }
}

// 1 4 6 4 1 
// (1) (4/1) (4/1 *3/2) (4/1 *3/2 * 2/3) (4/1 *3/2 * 2/3 * 1/4)
// 1     2       3           4               5 
//       1       2           3               4