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




