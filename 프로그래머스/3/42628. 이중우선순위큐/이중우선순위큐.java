import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        
        for (String s : operations){
            String[] split = s.split(" ");
            if (split[0].equals("I")){
                minQueue.add(Integer.parseInt(split[1]));
                maxQueue.add(Integer.parseInt(split[1]));
            } else if (split[0].equals("D")){
                if (minQueue.isEmpty() || maxQueue.isEmpty()){
                    continue;
                }
                if (split[1].equals("-1")){
                    int minP = minQueue.poll();
                    maxQueue.remove(minP);
                } else {
                    int maxP = maxQueue.poll();
                    minQueue.remove(maxP);
                }
                
            }
        }
        
        if (minQueue.isEmpty() || maxQueue.isEmpty()){
            return answer;
        } else {
            answer[1] = minQueue.poll();
            answer[0] = maxQueue.poll();
        }
        return answer;
    }
}