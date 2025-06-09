import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>();
 
        for (int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.size() > 1){   
            int first = pq.poll();
            
            if (first >= K){
                break;
            }
            
            int second = pq.poll();
            int newScovile = first + second * 2;
            answer++;
            pq.add(newScovile);
        }
        
        if (pq.size() == 1){
            if (pq.poll() < K){
                return -1;
            }
        }
        
        return answer;
    }
}