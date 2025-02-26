import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    private static class Node {
        int node, sheep, wolf;
        HashSet<Integer> visited;

        public Node(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }

    private static ArrayList<Integer>[] tree;

    private static void buildTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {

            tree[edge[0]].add(edge[1]);

        }
    }


    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        buildTree(info, edges);

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 1, 0, new HashSet<>()));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            now.visited.addAll(tree[now.node]);

            answer = Math.max(answer, now.sheep);

            for (int next : now.visited) {
                HashSet<Integer> newSet = new HashSet<>(now.visited);
                newSet.remove(next);
                newSet.addAll(tree[next]);

                if (info[next] == 1) {
                    if (now.sheep > now.wolf + 1) {
                        queue.add(new Node(next, now.sheep, now.wolf + 1, newSet));
                    }
                } else {
                    queue.add(new Node(next, now.sheep + 1, now.wolf, newSet));

                }


            }


        }


        return answer;
    }
}