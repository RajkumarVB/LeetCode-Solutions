class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length; 
        int[] satisfyLeft = new int[n];
    
        satisfyLeft[0] = 1; 
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                satisfyLeft[i] = satisfyLeft[i-1] + 1; 
            }else{
                satisfyLeft[i] =1; 
            }
        }

        int totalCandies = Math.max(1, satisfyLeft[n-1]); 
        int prevGiven = 1; 
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                totalCandies += Math.max(prevGiven + 1, satisfyLeft[i]); 
                prevGiven += 1; 
            }else{
                prevGiven = 1; 
                totalCandies += Math.max(1, satisfyLeft[i]); 
            }
        }
        
        return totalCandies; 
    }
}

// 1 2 2 

// 1 2 1 
// 1 1 1

// 2 1 2 
// 1 1 2
// 2 1 1