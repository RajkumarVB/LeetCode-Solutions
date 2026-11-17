class Solution {
    public int fib(int n) {
        return calcFib(n);
    }
    public static int calcFib(int n){
        if(n ==0 || n==1) return n ;
        return calcFib(n-1) + calcFib(n-2);
    }
}