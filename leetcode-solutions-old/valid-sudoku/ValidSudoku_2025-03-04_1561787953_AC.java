class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> rows = new ArrayList<>(); 
        ArrayList<HashSet<Character>> cols = new ArrayList<>();
        ArrayList<HashSet<Character>> boxes = new ArrayList<>();

        for(int i=0; i<9; i++){
            rows.add(new HashSet<>()); 
            cols.add(new HashSet<>()); 
            boxes.add(new HashSet<>()); 
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char num = board[i][j]; 
                if(num == '.') continue; 
                if(rows.get(i).contains(num)) return false;
                rows.get(i).add(num);
                if(cols.get(j).contains(num)) return false; 
                cols.get(j).add(num);

                int boxNo = ((i / 3) * 3) + (j / 3);
                if(boxes.get(boxNo).contains(num)) return false; 
                boxes.get(boxNo).add(num); 
            }
        }
        return true; 
    }
}