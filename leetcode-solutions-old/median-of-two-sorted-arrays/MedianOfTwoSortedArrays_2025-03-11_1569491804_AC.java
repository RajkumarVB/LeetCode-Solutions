class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; 
        int n2 = nums2.length;

        if(n1 > n2) return findMedianSortedArrays(nums2, nums1); 
        int noOfLeftPartitionElements = (n1 + n2) /2 ;
        int low = 0, high = n1; 

        while(low <= high){
            int mid = (low + high) /2 ;
            int l1 = (mid -1 >= 0) ? nums1[mid -1] : Integer.MIN_VALUE; 
            int r1 = (mid < n1) ? nums1[mid] : Integer.MAX_VALUE; 

            int mid2 = noOfLeftPartitionElements - mid; 

            int l2 = (mid2 -1) >= 0 ? nums2[mid2 -1] : Integer.MIN_VALUE; 
            int r2 = mid2 < n2 ? nums2[mid2] : Integer.MAX_VALUE; 

            if(l1 <= r2 && l2 <= r1){
                System.out.println("noOfLeftPartitionElements = "+ noOfLeftPartitionElements); 
                System.out.println("l1 = " + l1 + " r1 = " + r1 + " l2 = " + l2+ " r2 = " + r2); 
                if((n1 + n2) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0; 
                }else{
                    return Math.min(r1,r2); 
                }
            }
            if(l1 > r2){
                high = mid -1; 
            }else {
                low = mid + 1; 
            }
        }
        return -1; 
    }
}