class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> cars = new LinkedList<>(); 
        for(int i=0; i<position.length; i++){
            cars.add(new Pair(position[i], speed[i])); 
        }

        
        LinkedList<Double> timeStack = new LinkedList<>(); 
        cars.sort((c1, c2) -> c1.pos - c2.pos); 
        for(int i=cars.size() -1; i>=0; i--){
            Pair car = cars.get(i); 
            double currentTime = (double) (target - car.pos) / car.speed;

            if(!timeStack.isEmpty() && currentTime <= timeStack.getLast()){
                continue; 
            } else {
                timeStack.addLast(currentTime);
            }

        }
        return timeStack.size(); 
    }
    record Pair(int pos, int speed){

    }
}