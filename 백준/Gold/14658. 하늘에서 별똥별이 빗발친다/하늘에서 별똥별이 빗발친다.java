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
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<int[]> stars = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int[] ints = {x, y};
            stars.add(ints);
        }
        int ans = 0;

        for (int i = 0; i < stars.size(); i++) {
            int[] ints = stars.get(i);
            for (int j = 0; j < stars.size(); j++) {
                int cnt = 0;
                int cx = ints[0];
                int[] intsTwo = stars.get(j);
                int cy = intsTwo[1];
                for (int[] star : stars) {
                    int starX = star[0];
                    int starY = star[1];
                    if (starX >= cx && starX <= cx + l && starY >= cy && starY <= cy + l) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);


            }


        }


        System.out.println(k - ans);
    }


}
