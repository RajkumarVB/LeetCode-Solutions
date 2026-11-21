/*
 * 815. Bus Routes  [Hard]
 * https://leetcode.com/problems/bus-routes/
 * Topics: Array, Hash Table, Breadth-First Search
 *
 * Problem:     Each bus loops forever over a fixed list of stops. Starting at stop source
 *              (not on a bus), return the fewest buses you must ride to reach stop target,
 *              or -1.
 * Example:     routes=[[1,2,7],[3,6,7]], source=1, target=6 -> 2
 * Constraints: <= 500 routes, total stops <= 1e5
 *
 * Key idea:    BFS over buses, not stops. Map stop -> buses that visit it; each BFS level =
 *              one more bus. Mark buses and stops visited so each route is expanded only
 *              once.
 *
 * Approach:    BFS where nodes are buses, stop->buses map
 * Complexity:  time O(sum of route lengths), space O(sum of route lengths)
 * Submitted:   2026-01-01 (submission 1870921204, AC)
 */

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0; 

        HashMap<Integer, List<Integer>> adjList = new HashMap<>(); 
        for(int bus =0; bus<routes.length; bus++){
            for(int stop : routes[bus]){
                if(!adjList.containsKey(stop)){
                    adjList.put(stop, new LinkedList<>());
                }
                adjList.get(stop).add(bus);
            }
        }

        Deque<Pair> q = new LinkedList<>(); 
        
        Set<Integer> busTaken = new HashSet<>();
        Set<Integer> stopsTaken = new HashSet<>();
        stopsTaken.add(source);

        if(!adjList.containsKey(source)) return -1; 

        for(int bus : adjList.get(source)){
            q.add(new Pair(bus,1)); 
            busTaken.add(bus); 
        }
       

        while(!q.isEmpty()){
            Pair p = q.removeFirst(); 
            int currentBus = p.bus; 
            int busesTakenSoFar = p.busesTaken; 
            

            for(int stop : routes[currentBus]){
                if(stop == target) return busesTakenSoFar; 
                if(!stopsTaken.contains(stop)){
                    stopsTaken.add(stop);
                    for(int bus : adjList.get(stop)){
                        if(!busTaken.contains(bus)){
                            q.add(new Pair(bus, busesTakenSoFar + 1));
                            busTaken.add(bus);
                        }
                    }
                }
            }
        }
        return -1; 
    }

    record Pair(int bus, int busesTaken){
    }
}




