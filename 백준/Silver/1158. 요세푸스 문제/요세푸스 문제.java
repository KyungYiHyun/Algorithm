import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int cnt = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            cnt++;
            if (cnt == k) {
                answer.add(poll);
                cnt = 0;
            } else {
                queue.add(poll);
            }

        }
        System.out.print("<");
        for (int i = 0; i < answer.size(); i++) {
            if (i == answer.size() - 1) {
                System.out.print(answer.get(i) + ">");
                break;
            }
            System.out.print(answer.get(i) + ", ");
        }


    }


}