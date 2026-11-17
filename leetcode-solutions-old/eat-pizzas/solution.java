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