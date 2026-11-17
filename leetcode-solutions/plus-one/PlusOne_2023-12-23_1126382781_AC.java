class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length; 
        Deque<Integer> deque = new LinkedList<>(); 
        int carry = 0; 
        for(int i=n-1 ; i>=0 ; i--){
            int digit = digits[i]; 
            int sum = (i == n-1) ? digit + 1 + carry : digit + carry ; 
            carry = sum /10; 
            digit = sum % 10; 
            deque.addFirst(digit); 
        }
        if(carry != 0) deque.addFirst(carry); 

        // Copying Deque to Array
        int[] result = new int[deque.size()]; 
        int i =0; 
        while(deque.size() > 0){
            result[i++] = deque.removeFirst(); 
        }

        return result ;
    }
}