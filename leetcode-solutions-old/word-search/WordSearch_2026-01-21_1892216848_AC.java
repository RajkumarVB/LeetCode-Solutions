class Solution {
    private int[][] directions = new int[][] {{-1,0},{0,-1}, {0,1}, {1,0}};
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length; 

        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0) == board[i][j]){
                    if(exist(board, word, 0, i, j, new HashSet<>())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int wordIdx, int i, int j, HashSet<Point> usedLocations){
        int wordLen = word.length();
        int m = board.length, n = board[0].length; 

        
        Point currentPoint = new Point(i ,j);
        if(word.charAt(wordIdx) == board[i][j] && !usedLocations.contains(currentPoint)){
            if(wordIdx == wordLen -1 ) return true; 
            usedLocations.add(currentPoint);
            for(int[] dir : directions){
                int newX = i + dir[0];
                int newY = j + dir[1];
                if(newX >= 0 && newX <m && newY >=0 && newY <n){
                    if(exist(board, word, wordIdx+1, newX, newY, usedLocations)){
                        return true; 
                    }
                }
            }
            usedLocations.remove(currentPoint);
        }
        return false; 
    }

    record Point(int i, int j){};
}