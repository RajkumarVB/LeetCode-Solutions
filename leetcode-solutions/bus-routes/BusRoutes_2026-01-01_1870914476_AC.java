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

        Deque<Integer> q = new LinkedList<>(); 
        
        Set<Integer> busTaken = new HashSet<>();
        Set<Integer> stopsTaken = new HashSet<>();
        stopsTaken.add(source);
        if(!adjList.containsKey(source))return -1; 
        for(int bus : adjList.get(source)){
            q.add(bus); 
            busTaken.add(bus); 
        }

        int noOfBus =1; 

       

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int currentBus = q.removeFirst(); 
                for(int stop : routes[currentBus]){
                    if(stop == target) return noOfBus; 
                    if(!stopsTaken.contains(stop)){
                        stopsTaken.add(stop);
                        for(int bus : adjList.get(stop)){
                            if(!busTaken.contains(bus)){
                                q.add(bus);
                                busTaken.add(bus);
                            }
                        }
                    }
                }
            }
            noOfBus ++; 
        }
        return -1; 
    }
}


