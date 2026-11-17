class Solution {
    public long flowerGame(int n, int m) {
        long ans =0; 
        for(int i=1; i<=n; i++){
            if(i % 2 == 0){
                // i is even, you need the reuslt to be odd, so calculate no of odd number between 1 and m
                ans += noOfOddNumbers(m); 
            }else{
                ans += noOfEvenNumbers(m); 
            }
        }
        return ans; 
    }

    public long noOfOddNumbers(int x){
        if(x % 2 == 0) return x /2; 
        return ((x/2) + 1); 
    }
    public long noOfEvenNumbers(int x){
        return x /2; 
    }
}

