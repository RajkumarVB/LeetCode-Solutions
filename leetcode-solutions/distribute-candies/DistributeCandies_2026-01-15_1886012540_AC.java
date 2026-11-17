class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>(); 

        for(int candy : candyType){
            set.add(candy);
        }

        int differentCandies = set.size(); 

        if ((candyType.length / 2) > differentCandies){
            return differentCandies; 
        }
        return candyType.length / 2 ; 
    }
}