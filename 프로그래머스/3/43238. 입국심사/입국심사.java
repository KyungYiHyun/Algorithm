import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long left = 1;
        
        Arrays.sort(times); 
        
        long max = times[times.length - 1];    
        long right = max * n;
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            long cnt = 0;
            for (int i = 0; i < times.length; i++){
                cnt += mid / times[i];
            }

            if (cnt < n){
                left = mid + 1;
            } else {
                // answer = mid;
                answer = Math.min(answer, mid);
                right = mid - 1;
            }
        }
        
        return answer;
    }
}