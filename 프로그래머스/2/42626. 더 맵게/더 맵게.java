import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        while (true) {
            int fp = pq.poll();
            if (fp >= K) {
                break;
            }
            if (pq.isEmpty()){
                answer = -1;
                break;
            }
            answer++;
            int sp = pq.poll();
            pq.add(fp + 2 * sp);
        }


        return answer;
    }
}