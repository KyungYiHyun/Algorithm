import java.util.*;

public class Solution {
    public Queue<Integer> solution(int []arr) {
        int[] answer = {};
        ArrayDeque<Integer> queue = new ArrayDeque<>();    
        for (int i = 0; i < arr.length; i++){
            if (queue.isEmpty()){
                queue.add(arr[i]);
                continue;
            }
            
            if (queue.peekLast() == arr[i]){
                continue;
            }
            queue.add(arr[i]);
  
        }

        return queue;
    }
}