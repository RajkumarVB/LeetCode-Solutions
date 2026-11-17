class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length; 
        List<Car> cars = new LinkedList<>(); 
        for(int i=0; i<n; i++){
            cars.add(new Car(position[i], speed[i])); 
        }
        cars.sort((c1, c2) -> c1.position - c2.position); 
        LinkedList<Car> stack = new LinkedList<>(); 
        // System.out.println("Cars" + cars);
        
        for(int i=n-1; i>=0; i--){
            stack.add(cars.get(i)); 
            if(stack.size() >= 2){
                // check if the last two inserted cars form a fleet or not. 
                Car c1 = stack.get(stack.size()-1);
                Car c2 = stack.get(stack.size()-2);

                double time1 = (double) (target - c1.position) / c1.speed ; 
                double time2 = (double) (target - c2.position) / c2.speed ; 

                if(time1 <= time2){
                    stack.removeLast(); 
                }

            }
        }
        return stack.size(); 
    }
    
    record Car(int position, int speed){

    }
}