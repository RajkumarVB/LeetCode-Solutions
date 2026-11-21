/*
 * 210. Course Schedule II  [Medium]
 * https://leetcode.com/problems/course-schedule-ii/
 * Topics: Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort
 *
 * Problem:     Same setup as Course Schedule, but return a valid order to take all courses,
 *              or an empty array if impossible.
 * Example:     4, [[1,0],[2,0],[3,1],[3,2]] -> [0,1,2,3] or [0,2,1,3]
 * Constraints: <= 2000 courses
 *
 * Key idea:    Kahn's algorithm: the order nodes leave the queue is a topological order. If
 *              fewer than numCourses are output, there's a cycle.
 *
 * Approach:    Kahn's topological sort
 * Complexity:  time O(V + E), space O(V + E)
 * Submitted:   2026-01-01 (submission 1870797378, AC)
 */

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