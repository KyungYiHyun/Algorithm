import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;        
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        int allWeight = 0;
        int idx = 0;
        while(idx < truck_weights.length){
            answer++;
            
            if (!stk.isEmpty() && stk.peek() + bridge_length <= answer){
                allWeight -= truck_weights[idx - stk.size()];
                stk.poll();
            }
            
            
            if (stk.size() < bridge_length && weight >= allWeight + truck_weights[idx]){
                stk.addLast(answer);
            
                allWeight += truck_weights[idx];
                idx++;
                
    
            }
            
                
            }
            answer += bridge_length;
        
           return answer; 
        
        }
        
    }
