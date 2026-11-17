class Solution {
    class Pair{
        int key;
        int value; 
        public Pair(int key, int value){
            this.key = key;
            this.value = value; 
        }
    }
    private boolean[][] visited; 
    private int row; 
    private int col; 
    private char[][] grid; 
    public int numIslands(char[][] grid) {
        this.row = grid.length; 
        this.col = grid[0].length; 
        this.visited = new boolean[row][col];
        this.grid = grid; 


        int count = 0; 
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count ++; 
                    bfs(i,j);
                }
            }
        }
        return count; 
    }

    public void bfs(int x, int y) {
        Deque<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair p = queue.removeFirst();
            int i = p.key;
            int j = p.value;

            if (i >= 0 && i < row && j >= 0 && j < col && grid[i][j] == '1' && !visited[i][j]) {
                visited[i][j] = true;

                queue.addLast(new Pair(i - 1, j));
                queue.addLast(new Pair(i + 1, j));
                queue.addLast(new Pair(i, j - 1));
                queue.addLast(new Pair(i, j + 1));
            }
        }
    }
}