class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2; 

        if(n1 > n2) return findMedianSortedArrays(nums2, nums1); 
        int noOfLeftElements = (n + 1) /2;
        // 10 -> 5 on the left, 5 on the right
        // 9 -> 5 on the left, 4 on the right

        int left = 0 ,right = n1; 
        while(left <= right){
            // mid1 means how many elements you're picking from arr1
            int mid1 = (right - left)/2 + left; 

            int mid2 = noOfLeftElements - mid1; 

            int l1 = (mid1 - 1 >= 0)? nums1[mid1-1] : Integer.MIN_VALUE; 
            int l2 = (mid2 - 1 >= 0)? nums2[mid2-1] : Integer.MIN_VALUE; 

            int r1 = (mid1 <n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 <n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0; 
                }else{
                    return Math.max(l1,l2);
                }
            }else if(l1 > r2){
                right = mid1 -1; 
            }else{
                left = mid1 + 1; 
            }
        }
        return -1; 
    }
}