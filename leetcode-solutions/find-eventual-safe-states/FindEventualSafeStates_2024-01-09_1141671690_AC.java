class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length; 
        List<List<Integer>> newAdjList = new ArrayList<>(V); 

        for(int i=0; i<V; i++){
            newAdjList.add(new LinkedList<>()); 
        }
        int[] inDegree = new int[V];
        for(int i=0; i<V ; i++){
            for(int j =0; j<graph[i].length; j++){
                newAdjList.get(graph[i][j]).add(i); 
                inDegree[i]++; 
            }
        }


        Deque<Integer> queue = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(inDegree[i] == 0) queue.addLast(i); 
        }

        List<Integer> ans = new LinkedList<>(); 
        while(!queue.isEmpty()){
            int node = queue.removeFirst();
            ans.add(node);
            for(int neighbor : newAdjList.get(node)){
                inDegree[neighbor] -- ; 
                if(inDegree[neighbor] ==0){
                    queue.add(neighbor); 
                }
            }
        }

        ans.sort(null); 
        return ans; 

    }
}