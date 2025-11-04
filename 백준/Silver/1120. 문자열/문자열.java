import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int Alen = A.length();
        int Blen = B.length();
        int ans = 51;

        for (int i = 0; i < Blen - Alen + 1; i++) {
            int temp = 0;
            for (int j = 0; j < Alen; j++) {
                if (A.charAt(j) != B.charAt(i + j)) {
                    temp++;
                }
            }

            ans = Math.min(temp, ans);

        }

        System.out.println(ans);


    }
}
