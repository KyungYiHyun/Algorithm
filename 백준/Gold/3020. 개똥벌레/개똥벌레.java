import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] jongyu = new int[n / 2];
        int[] suksoon = new int[n / 2];

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                suksoon[i / 2] = k;
            } else {
                jongyu[i / 2] = k;
            }
        }
        Arrays.sort(suksoon);
        Arrays.sort(jongyu);
        int cnt = 0;
        int min = n;
        for (int i = 1; i < h + 1; i++) {
            int temp = binary_search(0, n / 2, i, suksoon) + binary_search(0, n / 2, h - i + 1, jongyu);
            if (temp < min) {
                min = temp;
                cnt = 1;
            } else if (temp == min) {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);

    }

    private static int binary_search(int left, int right, int current, int[] arr) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= current) {
                right = mid;

            } else {
                left = mid + 1;
            }
        }

        return arr.length - right;

    }


}
