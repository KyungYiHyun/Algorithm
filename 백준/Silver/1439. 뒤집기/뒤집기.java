import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int zero = 0;
        int one = 0;

        for (int i = 1; i < S.length(); i++) {
            char c = S.charAt(i - 1);
            char c2 = S.charAt(i);
            if (c != c2) {
                if (c == '1') {
                    one++;
                } else {
                    zero++;
                }
            }

            if (i == S.length() - 1) {
                if (c2 == '1') {
                    one++;
                } else {
                    zero++;
                }
            }
        }

        System.out.println(Math.min(one, zero));

    }


}
