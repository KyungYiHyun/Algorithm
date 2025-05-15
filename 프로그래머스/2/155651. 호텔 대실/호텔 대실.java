import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time,(a, b)->{
            return a[0].compareTo(b[0]);
        });
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < book_time.length; i++){
            String[] start = book_time[i][0].split(":");
            Integer startTotal = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            String[] end = book_time[i][1].split(":");
            Integer endTotal = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
            
            if (!queue.isEmpty() && queue.peek() <= startTotal){
                queue.poll();
            }
            
            queue.offer(endTotal);
            answer = Math.max(answer,queue.size());
            
        }
        return answer;
    }
}