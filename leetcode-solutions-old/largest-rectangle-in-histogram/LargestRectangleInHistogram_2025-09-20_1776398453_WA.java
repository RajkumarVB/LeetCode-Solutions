class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length; 
        int result = Integer.MIN_VALUE; 

        int[] nextSmallerElementToR = nextSmallerElement(heights); 
        int[] nextSmallerElementToL = nextSmallerElementToL(heights); 

        // System.out.println("nextSmallerElementToR " + Arrays.toString(nextSmallerElementToR));
        // System.out.println("nextSmallerElementToL " + Arrays.toString(nextSmallerElementToL));

        for(int i=0; i<n; i++){
            int area = (nextSmallerElementToR[i] - nextSmallerElementToL[i] - 1) *  heights[i];
            area = (area == 0) ? heights[i] : area; 
            result = Math.max(area, result);
        }
        return result; 
    }

    private int[] nextSmallerElement(int[] nums){
        int n = nums.length; 
        int[] result = new int[n]; 
        LinkedList<Integer> stack = new LinkedList<>(); 
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[i] <= nums[stack.getLast()]){
                stack.removeLast();
            }
            if(!stack.isEmpty()){
                result[i] = stack.getLast();
            }else{
                result[i] = i;
            }
            stack.addLast(i); 
        }
        return result; 
    }

    private int[] nextSmallerElementToL(int[] nums){
        int n = nums.length; 
        int[] result = new int[n]; 
        LinkedList<Integer> stack = new LinkedList<>(); 
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && nums[i] <= nums[stack.getLast()]){
                stack.removeLast();
            }
            if(!stack.isEmpty()){
                result[i] = stack.getLast();
            }else{
                result[i] = i;
            }
            stack.addLast(i); 
        }
        return result; 
    }
}

