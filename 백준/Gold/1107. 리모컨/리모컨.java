import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int length;
    static String N;
    static ArrayList<Integer> notBrokenButtons;

    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        notBrokenButtons = new ArrayList<>();
        result = Integer.MAX_VALUE;
        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                notBrokenButtons.add(Integer.parseInt(st.nextToken()));
            }
        }
        if (M == 10) {
            System.out.println(Math.abs(Integer.parseInt(N) - 100));
            System.exit(0);
        }

        if (N.equals("100")) {
            System.out.println(0);
            System.exit(0);
        }
        for (int i = 0; i < 10; i++) {
            if (notBrokenButtons.contains(i)) {
                notBrokenButtons.remove(notBrokenButtons.indexOf(i));
            } else {
                notBrokenButtons.add(i);
            }
        }

        length = N.length();
        int intN = Integer.parseInt(N);

        StringBuilder sb = new StringBuilder();
        makeCandidate(0, length, sb, intN);
        makeCandidate(0, length + 1, sb, intN);
        if (length - 1 > 0) {
            makeCandidate(0, length - 1, sb, intN);
        }

        System.out.println(Math.min(result, Math.abs(intN - 100)));

    }

    private static void makeCandidate(int depth, int target, StringBuilder sb, int intN) {
        if (depth == target) {
            int num = Integer.parseInt(sb.toString());
            int press = Math.abs(intN - num) + sb.length();
            result = Math.min(result, press);
            return;
        }

        for (int i = 0; i < notBrokenButtons.size(); i++) {
            sb.append(notBrokenButtons.get(i));
            makeCandidate(depth + 1, target, sb, intN);
            sb.deleteCharAt(sb.length() - 1);
        }

    }


}