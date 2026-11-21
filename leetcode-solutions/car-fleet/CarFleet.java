/*
 * 853. Car Fleet  [Medium]
 * https://leetcode.com/problems/car-fleet/
 * Topics: Array, Stack, Sorting, Monotonic Stack
 *
 * Problem:     Cars at different positions drive toward target at their own speeds. A
 *              faster car that catches a slower one joins it and moves at the slower speed.
 *              Count how many fleets arrive.
 * Example:     target=12, position=[10,8,0,5,3], speed=[2,4,1,1,3] -> 3
 * Constraints: n <= 1e5, positions unique
 *
 * Key idea:    Sort by position and walk from the car closest to target. Compute time-to-
 *              target; if a car's time is <= the fleet ahead of it, it merges (don't push).
 *              Otherwise it starts a new fleet.
 *
 * Approach:    Sort by position + stack of arrival times
 * Complexity:  time O(n log n), space O(n)
 * Submitted:   2025-09-18 (submission 1775240577, AC)
 */

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length; 
        List<Car> cars = new ArrayList<>(); 
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