class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        for (int i = 3; i < n + 1; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        answer = dp[n];
        return answer;
    }
}