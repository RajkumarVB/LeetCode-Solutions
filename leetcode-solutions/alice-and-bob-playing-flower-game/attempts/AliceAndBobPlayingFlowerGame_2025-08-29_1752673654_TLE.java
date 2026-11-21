class Solution {
    public long flowerGame(int n, int m) {
        long ans =0; 
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(canAlexWin(i,j)){
                    ans ++; 
                }
            }
        }
        return ans; 
    }

    public boolean canAlexWin(int x, int y){
        if( ((x+y) % 2) !=0 )return true;
        return false; 
    }
}

