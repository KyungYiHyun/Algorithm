import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        int left = 0;
        int right = N - 1;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            left = numbers.get(i);
            int sum = 0;
            sum += left;
            if (sum == M) {
                ans++;
                continue;
            }
            for (int j = i + 1; j < N; j++) {
                sum += numbers.get(j);
                if (sum == M) {
                    ans++;
                    break;
                } else if (sum > M) {
                    break;
                }
            }

        }
        System.out.println(ans);


    }
}
