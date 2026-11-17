class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(m < n) return false; 
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        for(int i=0; i<n; i++){
            s1Count[s1.charAt(i) -'a']++; 
            s2Count[s2.charAt(i) - 'a']++; 
        }
        int matches =0;
        for(int i=0; i<26; i++){
            if(s1Count[i] == s2Count[i]) matches ++; 
        }

        int i=0; 
        int j=n; 

        while(j < m){
            if(matches == 26) return true;
            
            int jIdx = s2.charAt(j) - 'a';
            s2Count[jIdx]++;
            if(s1Count[jIdx] == s2Count[jIdx]) matches ++; 
            else if(s1Count[jIdx] + 1 == s2Count[jIdx])matches --; // They were equal,now they are not, only then decrement the match. 
            j++; 


            int iIdx = s2.charAt(i) - 'a';
            s2Count[iIdx]--; 
            if(s1Count[iIdx] == s2Count[iIdx]) matches ++; 
            else if(s1Count[iIdx] - 1 == s2Count[iIdx]) matches --; // They were equal,now they are not, only then decrement the match. 
            i++; 
        }
        return matches == 26; 
    }
}