import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            int cur = numbers[i];
            while (start < end) {
                if (start == i) {
                    start++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }
                if (numbers[start] + numbers[end] == cur) {
                    ans++;
                    break;

                } else if (numbers[start] + numbers[end] > cur) {
                    end--;
                } else if (numbers[start] + numbers[end] < cur) {
                    start++;
                }
            }
        }
        System.out.println(ans);
    }
}





