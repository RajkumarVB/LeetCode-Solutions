class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = createAdjList(numCourses, prerequisites);
        int[] inDegree = calculateInDegree(adjList); 
        List<Integer> topoSort = findTopoSort(adjList,inDegree);
        if(topoSort.size() != numCourses) return new int[]{}; 
        return topoSort.stream().mapToInt(Integer::intValue).toArray(); 
    }
    
    public List<Integer> findTopoSort(List<List<Integer>> adjList, int[] inDegree){
        int V = adjList.size(); 
        Queue<Integer> q = new LinkedList<>(); 
        List<Integer> result = new LinkedList<>(); 
        for(int i=0; i<V; i++){
            if(inDegree[i] ==0 ){
                q.offer(i); 
            }
        }
        while(!q.isEmpty()){
            int node = q.poll(); 
            result.add(node); 
            for(int neighbor : adjList.get(node)){
                inDegree[neighbor]--; 
                if(inDegree[neighbor] == 0){
                    q.offer(neighbor); 
                }
            }
        }
        return result; 
    }

    public int[] calculateInDegree(List<List<Integer>> adjList){
        int V = adjList.size(); 
        int[] inDegree = new int[V];
        for(int i=0; i<V; i++){
            for(int neighbor : adjList.get(i)){
                inDegree[neighbor] ++; 
            }
        }
        return inDegree; 
    }

    public List<List<Integer>> createAdjList(int numCourses, int[][] prerequisites){
        List<List<Integer>> adjList = new ArrayList<>(); 
        for(int i=0; i<numCourses; i++){
            adjList.add(new LinkedList<>()); 
        }
        for(int[] prerequisite : prerequisites){
            int u = prerequisite[1];
            int v = prerequisite[0];
            adjList.get(u).add(v); 
        }
        return adjList; 
    }
}