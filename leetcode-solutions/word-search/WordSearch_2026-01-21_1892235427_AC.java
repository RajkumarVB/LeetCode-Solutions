class Solution {
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0) == board[i][j]){
                    if(isWordPresent(board, word, 0, i, j, new HashSet<>())){
                        return true; 
                    }
                }
            }
        }
        return false; 
    }

    private boolean isWordPresent(char[][] board, String word ,int wordIdx, int i, int j, HashSet<Point> usedLocations){
        int m = board.length, n = board[0].length; 
        Point currentPoint = new Point(i, j);
        if(i <0 || i>=m || j<0 || j>=n || board[i][j] != word.charAt(wordIdx) || usedLocations.contains(currentPoint)){
            return false; 
        }

        if(wordIdx == word.length() -1){
            return true; 
        }
        usedLocations.add(currentPoint);
        boolean matched =  isWordPresent(board, word, wordIdx + 1, i+1,j,usedLocations) || isWordPresent(board, word, wordIdx + 1, i-1,j,usedLocations)
                                || isWordPresent(board, word, wordIdx + 1, i,j-1,usedLocations) || isWordPresent(board, word, wordIdx + 1, i,j+1,usedLocations);

        usedLocations.remove(currentPoint);
        return matched;
    }

    record Point(int i, int j){};
}