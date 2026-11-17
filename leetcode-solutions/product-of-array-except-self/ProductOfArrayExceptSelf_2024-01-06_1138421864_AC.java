class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 

        int[] prefixProduct = new int[n]; 
        int[] suffixProduct = new int[n]; 

        int prefixProd = 1; 
        int suffixProd = 1; 

        for(int i=0; i<n ;i++){
            prefixProduct[i] = prefixProd;
            suffixProduct[n-1-i] = suffixProd;

            prefixProd *= nums[i];
            suffixProd *= nums[n-1-i];
        }

        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = prefixProduct[i] * suffixProduct[i]; 
        }


        // System.out.println(Arrays.toString(prefixProduct));
        // System.out.println(Arrays.toString(suffixProduct));
        return result; 
    }
}