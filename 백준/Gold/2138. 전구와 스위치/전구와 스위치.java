import java.awt.image.RasterOp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] current = new int[n];
        int[] target = new int[n];
        String first = br.readLine();
        String second = br.readLine();
        for (int i = 0; i < n; i++) {
            if (first.charAt(i) == '0') {
                current[i] = 0;
            } else {
                current[i] = 1;
            }
            if (second.charAt(i) == '0') {
                target[i] = 0;
            } else {
                target[i] = 1;
            }
        }

        int result = 0;
        int ans1 = 0;
        int ans2 = 0;
        int[] clone = current.clone();
        for (int i = 1; i < n; i++) {
            if (current[i - 1] != target[i - 1]) {
                if (i == n - 1) {
                    current[i] = 1 - current[i];
                    current[i - 1] = 1 - current[i - 1];
                } else {
                    current[i] = 1 - current[i];
                    current[i - 1] = 1 - current[i - 1];
                    current[i + 1] = 1 - current[i + 1];
                }
                ans1++;
            }
            if (Arrays.equals(current, target)) {
                break;
            }
        }

        if (!Arrays.equals(current, target)) {
            ans1 = -1;
        }

        clone[0] = 1 - clone[0];
        clone[1] = 1 - clone[1];
        ans2++;
        for (int i = 1; i < n; i++) {
            if (clone[i - 1] != target[i - 1]) {
                if (i == n - 1) {
                    clone[i] = 1 - clone[i];
                    clone[i - 1] = 1 - clone[i - 1];
                } else {
                    clone[i] = 1 - clone[i];
                    clone[i - 1] = 1 - clone[i - 1];
                    clone[i + 1] = 1 - clone[i + 1];
                }
                ans2++;
            }
            if (Arrays.equals(clone, target)) {
                break;
            }
        }

        if (!Arrays.equals(clone, target)) {
            ans2 = -1;
        }
        if (ans1 == -1 && ans2 == -1) {
            System.out.println(-1);
        } else if (ans1 == -1) {
            System.out.println(ans2);
        } else if (ans2 == -1) {
            System.out.println(ans1);
        } else {
            result = Math.min(ans1, ans2);
            System.out.println(result);
        }


    }
}
