import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> nums = new ArrayList<>();
        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums.add(num);
        }

        Collections.sort(nums);

        int max_diff = Collections.max(nums) - Collections.min(nums);

        while (end < N && start < N) {
            int temp = nums.get(end) - nums.get(start);
            if (temp >= M) {
                max_diff = Math.min(max_diff, temp);
                start++;
            } else {
                end++;
            }
        }

        System.out.println(max_diff);
    }
}