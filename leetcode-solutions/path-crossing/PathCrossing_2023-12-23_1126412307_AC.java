class Solution {
        public static boolean isPathCrossing(String path) {
        HashSet<Pair<Integer,Integer>> visited = new HashSet<>();
        
        int x = 0; 
        int y = 0; 

        Pair<Integer,Integer> p = new Pair(0,0);
        visited.add(p);

        for(char c : path.toCharArray()){
            if(c == 'N'){
                y += 1; 
            } else if(c == 'S'){
                y -=1; 
            } else if(c =='E'){
                x +=1 ; 
            } else{
                x -= 1; 
            }
            p = new Pair(x, y); 

            if(visited.contains(p)) return true;
            visited.add(p);
        }
        
        return false;
    }
}