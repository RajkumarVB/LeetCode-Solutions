class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> cars = new ArrayList<>(); 
        for(int i=0; i<position.length; i++){
            cars.add(new Pair(position[i], speed[i])); 
        }

        
        ArrayList<Double> timeStack = new ArrayList<>(); 
        cars.sort((c1, c2) -> c1.pos - c2.pos); 
        for(int i=cars.size() -1; i>=0; i--){
            Pair car = cars.get(i); 
            double currentTime = (double) (target - car.pos) / car.speed;
            timeStack.addLast(currentTime); 
            int n = timeStack.size();
            if(n >=2 && timeStack.get(n-1) <= timeStack.get(n-2)){
                timeStack.removeLast(); 
            }

        }
        return timeStack.size(); 
    }
    record Pair(int pos, int speed){

    }
}