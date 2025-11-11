import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Node {
        int idx;
        int score;

        public Node(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Node> scores = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int x = Integer.parseInt(br.readLine());
            scores.add(new Node(i + 1, x));
        }

        Collections.sort(scores, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.score - o1.score;
            }
        });

        int sum = 0;

        ArrayList<Integer> idxs = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int score = scores.get(i).score;
            int idx = scores.get(i).idx;
            sum += score;
            idxs.add(idx);
        }
        Collections.sort(idxs);
        System.out.println(sum);
        for (Integer idx : idxs) {
            System.out.print(idx + " ");
        }


    }


}
