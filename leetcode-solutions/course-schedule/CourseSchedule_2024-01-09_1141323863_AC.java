class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = createAdjacencyList(numCourses,prerequisites);
        int[] inDegree = calculateInDegree(numCourses,prerequisites);
        List<Integer> topoSort = topologicalSort(numCourses, adjacencyList,inDegree);

        if(topoSort.size() != numCourses) return false; 
        return true; 
    }

    public int[] calculateInDegree(int numCourses, int[][] prerequisites){
        int[] inDegree = new int[numCourses]; 
        for(int[] edge : prerequisites){
            inDegree[edge[0]]++; 
        }
        return inDegree;
    }

    public List<List<Integer>> createAdjacencyList(int numCourses, int[][] prerequisites){
        List<List<Integer>> adjacencyList = new ArrayList<>(numCourses);
        
        for(int i=0; i<numCourses; i++){
            adjacencyList.add(new LinkedList<>()); 
        }


        for(int[] edge : prerequisites){
            adjacencyList.get(edge[1]).add(edge[0]); 
        }

        return adjacencyList; 
    }

    public List<Integer> topologicalSort(int numCourses, List<List<Integer>> adjacencyList, int[] inDegree){
        
        Deque<Integer> queue = new LinkedList<>(); 
        List<Integer> ans = new LinkedList<>(); 
        
        
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                queue.addLast(i); 
            }
        }

        while(!queue.isEmpty()){
            int node = queue.removeFirst(); 
            ans.add(node); 

            for(int neighbor : adjacencyList.get(node)){
                inDegree[neighbor]--; 
                if(inDegree[neighbor] == 0){
                    queue.addLast(neighbor);    
                }
                
            }
        }
        return ans;
    }
}