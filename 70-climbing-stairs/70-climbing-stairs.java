class Solution {
    

    public int climbStairs(int n) {
        int dp[]=new int [n+1];
        dp[0]=1;
        for(int i=1;i<dp.length;i++)
        {
            int ans=0;
            if(i>=1)
                ans+=dp[i-1];
            if(i>=2)
                ans+=dp[i-2];
            dp[i]=ans;
        }
        return dp[n];
    }
}