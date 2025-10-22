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
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> leaks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            leaks.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(leaks);

        int ans = 1;
        int cri = leaks.get(0) + L;

        for (int i = 1; i < N; i++) {
            if (leaks.get(i) >= cri) {
                ans++;
                cri = leaks.get(i) + L;
            }
        }

        System.out.println(ans);


    }


}
