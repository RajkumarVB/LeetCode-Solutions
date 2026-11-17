class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length; 
        int[] satisfyLeft = new int[n];
        int[] satisfyRight = new int[n];
        
        satisfyLeft[0] = 1; 
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                satisfyLeft[i] = satisfyLeft[i-1] + 1; 
            }else{
                satisfyLeft[i] =1; 
            }
        }
        satisfyRight[n-1] = 1; 
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                satisfyRight[i] = satisfyRight[i+1] + 1; 
            }else{
                satisfyRight[i] =1; 
            }
        }

        int totalCandies = 0; 
        for(int i=0; i<n; i++){
            totalCandies += Math.max(satisfyLeft[i], satisfyRight[i]);
        }
        return totalCandies; 
    }
}

// 1,2,2

// 1 2 1

// 1 2 3 4 2 4 1 8

// 1 2 3 4 1 2 1 2 

// 1 2 3 4 1 2 1 2 
// 1 1 1 2 1 2 1 1