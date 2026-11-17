class Solution {
    public boolean isHappy(int n) {
        HashSet<Long> set = new HashSet<>(); 
        set.add((long) n); 

        long squareNo = n; 
        while(squareNo != 1){
            squareNo = square(squareNo); 
            if(set.contains(squareNo)) return false; 
            set.add(squareNo); 
        }

        return true; 
    }
    public static long square(long n){
        long ans =0; 
        while(n !=0){
            int lastDigit = (int) (n % 10); 
            ans += Math.pow(lastDigit,2); 
            n /= 10; 
        }
        return ans; 
    }
}