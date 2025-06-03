import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int ans = 100001;
        
        // 결과가 limit보다 작으면 후보에 추가 -> 왼쪽
        // 결과가 limit보다 크면 -> 오른쪽
        
        int start = 1;
        int end = Arrays.stream(diffs).max().getAsInt();
        
        while(start <= end){
            int mid = (start + end) / 2;
            long curTime = 0; 
            for (int i = 0; i < diffs.length; i++){
                if (diffs[i] > mid){
                    long temp = diffs[i] - mid;
                    curTime += (times[i - 1] + times[i]) * temp + times[i];
                } else {
                    curTime += times[i];
                }
                 if (curTime > limit) break;
            } 
            System.out.println(curTime);
            if (curTime > limit){
                start = mid + 1;
            } else {
                end = mid - 1;
                ans = Math.min(ans, mid);
            }
            
        }
        
        
        return ans;
    }
}