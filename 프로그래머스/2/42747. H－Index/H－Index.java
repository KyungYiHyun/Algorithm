import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        int maxNum = citations[citations.length - 1];
            
        for (int i = maxNum; i >= 0; i--){
            int cnt = 0;
            for (int j = 0; j < citations.length; j++){
                if(citations[j] >= i){
                    cnt++;
                }
            }            
            if (cnt >= i){
                return i;
            }
            
        }
        
        
        return answer;
    }
}