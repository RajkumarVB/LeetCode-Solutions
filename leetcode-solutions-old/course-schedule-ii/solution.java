class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = buildAdjacencyList(numCourses, prerequisites); 
        int[]inDegree = computeInDegreee(numCourses, adjList);
        List<Integer> topoSort = computeTopoSort(adjList, numCourses, inDegree) ;

        if(topoSort.size() != numCourses) {
            return new int[]{}; 
        }
        return topoSort.stream().mapToInt(i -> i.intValue()).toArray();
    }

    private int[] computeInDegreee(int n, List<List<Integer>> adjList){
        int[] inDegree = new int[n]; 
        for(int i=0; i<adjList.size(); i++){
            for(int neighbor : adjList.get(i)){
                inDegree[neighbor] ++; 
            }
        }
        return inDegree; 
    }

    private List<List<Integer>> buildAdjacencyList(int numCourses, int[][] prerequisites){
        List<List<Integer>> adjList = new ArrayList<>(); 
        for(int i=0; i<numCourses; i++){
            adjList.add(new LinkedList<>());
        }

        for(int[] edge : prerequisites){
            int node1 = edge[1];
            int node2 = edge[0];

            // node1 -> node2 

            adjList.get(node1).add(node2); 
        }
        return adjList; 
    }

    private List<Integer> computeTopoSort(List<List<Integer>> adjList, int n, int[] inDegree){
        Deque<Integer> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            if(inDegree[i] ==0){
                q.addLast(i); 
            }    
        }
        List<Integer> result = new LinkedList<>();

        while(!q.isEmpty()){
            int node = q.removeFirst(); 
            result.add(node); 

            for(int neighbor : adjList.get(node)){
                inDegree[neighbor] --; 
                if(inDegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        return result; 
    }
}