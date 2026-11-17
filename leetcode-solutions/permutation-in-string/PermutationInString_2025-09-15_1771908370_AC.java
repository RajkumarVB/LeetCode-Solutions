class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Count initial window
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matchingChars = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) matchingChars++;
        }

        int windowStart = 0;
        for (int windowEnd = s1.length(); windowEnd < s2.length(); windowEnd++) {
            if (matchingChars == 26) return true;

            // remove char from left
            int leftIndex = s2.charAt(windowStart) - 'a';
            if (s1Count[leftIndex] == s2Count[leftIndex]) matchingChars--;
            s2Count[leftIndex]--;
            if (s1Count[leftIndex] == s2Count[leftIndex]) matchingChars++;
            windowStart++;

            // add char from right
            int rightIndex = s2.charAt(windowEnd) - 'a';
            if (s1Count[rightIndex] == s2Count[rightIndex]) matchingChars--;
            s2Count[rightIndex]++;
            if (s1Count[rightIndex] == s2Count[rightIndex]) matchingChars++;
        }

        return matchingChars == 26;
    }
}
