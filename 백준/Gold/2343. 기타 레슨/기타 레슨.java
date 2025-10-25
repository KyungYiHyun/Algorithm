import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> lessons = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lessons.add(Integer.parseInt(st.nextToken()));
        }

        int left = lessons.stream().mapToInt(n -> n).max().getAsInt();
        int right = lessons.stream().mapToInt(Integer::intValue).sum();
        int answer = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int sum = lessons.get(0);
            for (int i = 0; i < N - 1; i++) {
                sum += lessons.get(i + 1);
                if (sum > mid) {
                    count++;
                    sum = lessons.get(i + 1);
                }
            }

            if (count > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }


        }

        System.out.println(answer);
    }


}
