class lc63 {
    public int uniquePathsWithObstacles(int[][] arr) {
        int dp[][]=new int[arr.length][arr[0].length];
        return recursion(arr,0,0,dp);
    }

    public int recursion(int[][] arr,int row,int col,int[][] dp){
        if(row>=arr.length || col>=arr[0].length || arr[row][col]==1) return 0;
        if(row==arr.length-1 && col==arr[0].length-1) return 1;
        if(dp[row][col]!=0) return dp[row][col];
        dp[row][col]= recursion(arr,row+1,col,dp)+recursion(arr,row,col+1,dp);
        return dp[row][col];
    }
}