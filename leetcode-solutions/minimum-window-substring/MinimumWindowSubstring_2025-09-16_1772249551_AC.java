class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for(char c : t.toCharArray()){
            int count = targetMap.getOrDefault(c, 0);
            targetMap.put(c, count + 1);
        }

        int have = 0;
        int need = targetMap.size();

        int left =0, right = 0;
        int startingPoint = -1, resultLength = Integer.MAX_VALUE;

        for(; right < s.length(); right++){
            int count = windowMap.getOrDefault(s.charAt(right), 0);
            windowMap.put(s.charAt(right), count + 1);
            count ++ ;
            if(count == targetMap.getOrDefault(s.charAt(right), 0)){
                have ++;
            }

            // shrinking the window
            while(have == need && left <= right){
                if(have >= need && (right - left + 1) < resultLength ){
                    startingPoint = left;
                    resultLength = right - left + 1;
                }

                count = windowMap.getOrDefault(s.charAt(left), 0);
                windowMap.put(s.charAt(left), count - 1);
                count --;
                if(count + 1 == targetMap.getOrDefault(s.charAt(left), 0)){
                    have --;
                }
                left ++;
            }
        }

        return (startingPoint == -1) ? "" : s.substring(startingPoint, startingPoint + resultLength);

    }
}