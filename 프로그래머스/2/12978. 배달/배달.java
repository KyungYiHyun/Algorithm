import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.cost = cost;
            this.dest = dest;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<Node>[] adjList = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            adjList[r[0]].add(new Node(r[1], r[2]));
            adjList[r[1]].add(new Node(r[0], r[2]));
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);


        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.cost, o2.cost);
        });

        pq.add(new Node(1, 0));
        distance[1] = 0;

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (now.cost > distance[now.dest]) {
                continue;
            }


            for (Node next : adjList[now.dest]) {
                if (distance[next.dest] > now.cost + next.cost) {
                    distance[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, distance[next.dest]));

                }


            }


        }


        for (int i = 1; i < N + 1; i++) {
            if (distance[i] <= K) {
                answer++;
            }

        }


        return answer;
    }
}