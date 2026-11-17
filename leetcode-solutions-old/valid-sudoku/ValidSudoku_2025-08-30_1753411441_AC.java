class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> rows = new ArrayList<>(9); 
        List<HashSet<Character>> cols = new ArrayList<>(9); 
        List<HashSet<Character>> boxes = new ArrayList<>(9);

        for(int i=0; i<9; i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for(int i=0;i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                char currentChar = board[i][j]; 
                if(currentChar == '.') continue; 

                int boxNumber = ((i/3) * 3) + (j /3) ; 
                if(rows.get(i).contains(currentChar) || cols.get(j).contains(currentChar) || 
                    boxes.get(boxNumber).contains(currentChar)){
                    // already contains so not a valid sudoku
                    System.out.println(rows);
                    System.out.println(cols);
                    System.out.println(boxes);
                    return false; 
                }
                rows.get(i).add(currentChar);
                cols.get(j).add(currentChar);
                boxes.get(boxNumber).add(currentChar); 
            }
        }
        return true; 
    }
}
// (i/3 * 3)+ j /3
// formula to find the box number for given i,j

