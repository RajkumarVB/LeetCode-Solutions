/*
 * 412. Fizz Buzz  [Easy]
 * https://leetcode.com/problems/fizz-buzz/
 * Topics: Math, String, Simulation
 *
 * Problem:     For 1..n output "FizzBuzz" if divisible by 15, "Fizz" if by 3, "Buzz" if by
 *              5, else the number.
 * Example:     n=5 -> [1,2,Fizz,4,Buzz]
 * Constraints: n <= 1e4
 *
 * Key idea:    Check the combined case (3 and 5) first.
 *
 * Approach:    Simulation
 * Complexity:  time O(n), space O(1) extra
 * Submitted:   2023-12-23 (submission 1126809956, AC)
 */

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new LinkedList<>(); 
        for(int i=1; i<=n; i++){
            if(i %3 ==0 && i %5 ==0){
                result.add("FizzBuzz");
            } else if(i %3 ==0){
                result.add("Fizz");
            } else if(i %5 ==0){
                result.add("Buzz");
            } else{
                result.add(String.valueOf(i)); 
            }
        }
        return result; 
    }
}