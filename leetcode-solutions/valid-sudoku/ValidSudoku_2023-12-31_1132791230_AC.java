class Solution {
    HashMap<Integer,HashSet<Character>> rowSets; 
    HashMap<Integer,HashSet<Character>> colSets; 
    HashMap<Pair<Integer,Integer>,HashSet<Character>> boxSetsMap;


    public Solution(){
        rowSets = new HashMap<>();
        colSets = new HashMap<>();
        boxSetsMap = new HashMap<>(); 

        for(int i=0; i<9 ; i++){
            rowSets.put(i,new HashSet<>());
            colSets.put(i,new HashSet<>());
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                Pair<Integer,Integer> p = new Pair(i,j); 
                boxSetsMap.put(p,new HashSet<>()); 
            }
        }
    }

    public boolean isValidSudoku(char[][] board) {
        int n = board.length; 

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                char c = board[i][j];
                if(c == '.') continue; 
                
                if(rowSets.get(i).contains(c)) return false; 
                if(colSets.get(j).contains(c)) return false; 
                

                int boxI = i/3; 
                int boxJ = j/3;  

                Pair p = new Pair(boxI, boxJ); 
                
                if(boxSetsMap.get(p).contains(c)) return false; 

                rowSets.get(i).add(c);
                colSets.get(j).add(c);
                boxSetsMap.get(p).add(c); 
            }
        }
        return true; 
    }
}