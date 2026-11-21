/*
 * 3457. Eat Pizzas!  [Medium]
 * https://leetcode.com/problems/eat-pizzas/
 * Topics: Array, Greedy, Sorting
 *
 * Problem:     Eat exactly 4 pizzas per day. On odd days you gain the heaviest of the four,
 *              on even days the second heaviest. Maximise total weight gained.
 * Example:     [1,2,3,4,5,6,7,8] -> 14 (day1 gets 8, day2 gets 6)
 * Constraints: n <= 2e5, multiple of 4
 *
 * Key idea:    Sort. Odd days (ceil(days/2) of them) take the largest pizzas outright. Even
 *              days each need two big pizzas and gain the smaller of the pair, so take
 *              every second pizza from what remains at the top. Fill each day with the
 *              smallest pizzas.
 *
 * Approach:    Sort + greedy simulation
 * Complexity:  time O(n log n + n^2) (list removals), space O(n)
 * Submitted:   2025-02-16 (submission 1544644034, AC)
 */

class Solution {
    public long maxWeight(int[] pizzas) {
        int n = pizzas.length; 
        int days = n / 4; 

        List<Integer> pizzasList = new LinkedList<>(); 
        for(int pizza : pizzas) pizzasList.add(pizza); 

        long maxWeight = 0; 
        pizzasList.sort(null); 
        // System.out.println(pizzasList);
        for(int day =1; day<=days; day +=2){
            maxWeight += pizzasList.get(pizzasList.size()-1); 
            
            pizzasList.remove(pizzasList.size()-1); 
            for(int i=0; i<3;i++){
                pizzasList.remove(0);
            }
        }
        // System.out.println(maxWeight);
        // System.out.println(pizzasList);
        for(int day =2; day<=days; day +=2){
            maxWeight += pizzasList.get(pizzasList.size()-2); 
            
            pizzasList.remove(pizzasList.size()-2); 
            pizzasList.remove(pizzasList.size()-1); 
            for(int i=0; i<2;i++){
                pizzasList.remove(0);
            }
        }
        
        return maxWeight; 
    }
}

// Always eat the heaviest pizza on the odd day