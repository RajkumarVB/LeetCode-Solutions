class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjList = computeAdjList(graph, graph.length);

        int[] inDegree = computeInDegree(adjList, graph.length);
        List<Integer> topoSort = computeTopoSort(adjList, inDegree);

        topoSort.sort(null);
        return topoSort; 
    }

    private List<List<Integer>> computeAdjList(int[][] graph, int noOfNodes){
       List<List<Integer>> adjList = new ArrayList<>();
       for(int i=0; i<noOfNodes; i++){
            adjList.add(new LinkedList<>());
       }

       for(int i=0; i<graph.length; i++){
            for(int j=0; j< graph[i].length; j++){
                adjList.get(graph[i][j]).add(i);
            }
       }
       return adjList;
    }

    private int[] computeInDegree(List<List<Integer>> adjList, int noOfNodes){
        int[] inDegree = new int[noOfNodes];
        for(int i=0; i<adjList.size(); i++){
            for(int neighbor : adjList.get(i)){
                inDegree[neighbor]++;
            }
        }
        return inDegree;
    }

    private List<Integer> computeTopoSort(List<List<Integer>> adjList, int[] inDegree){
        LinkedList<Integer> q = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                q.addLast(i);
            }
        }
        List<Integer> result = new LinkedList<>();

        while(!q.isEmpty()){
            int node = q.removeFirst();
            result.add(node);

            for(int neighbor : adjList.get(node)){
                inDegree[neighbor]--; 
                if(inDegree[neighbor] == 0){
                    q.addLast(neighbor);
                }
            }
        }
        return result;
    }


}