class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int ans = 0;
        int maxF = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            maxF = Math.max(maxF,arr[s.charAt(j) - 'A']);
            while (j - i + 1 - maxF > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
                // While decrementing we no need to update max, that will not affect the answer. 
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}