class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> rows = new ArrayList<>();
        List<HashSet<Character>> cols = new ArrayList<>();
        HashMap<Pair,HashSet<Character>> boxes = new HashMap<>();
        int n = board.length; 
        for(int i=0; i<n; i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }

        for(int i=0; i<n/3; i++){
            for(int j=0; j<n/3; j++){
                boxes.put(new Pair(i,j),new HashSet<>()); 
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == '.') continue; 

                char c = board[i][j];

                if(rows.get(i).contains(c) || cols.get(j).contains(c) || boxes.get(new Pair(i/3,j/3)).contains(c)) return false; 

                rows.get(i).add(c);
                cols.get(j).add(c);
                boxes.get(new Pair(i/3,j/3)).add(c); 
            }
        }
        return true; 
    }
}

record Pair(int i, int j){

}