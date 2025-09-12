import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        int[][] dp = new int[2][money.length];
        dp[0][0] = money[0];
        dp[1][1] = money[1];
        dp[1][2] = Math.max(money[1], money[2]);
        dp[0][1] = Math.max(money[0], money[1]);
        
        for(int i = 3; i < money.length; i++){
           
            dp[1][i] = Math.max(dp[1][i - 2] + money[i], dp[1][i - 1]);    
        }
        
         for(int i = 2; i < money.length - 1; i++){
          dp[0][i] = Math.max(dp[0][i - 2] + money[i], dp[0][i - 1]);   
        }
        
         
        answer = Math.max(dp[0][money.length - 2], dp[1][money.length - 1]);
     
        
        return answer;
    }
}