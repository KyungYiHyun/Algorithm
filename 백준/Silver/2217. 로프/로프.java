import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> ropes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ropes.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(ropes);
        int ans = -1;

        for (int i = 0; i < ropes.size(); i++) {
            int temp = ropes.get(i) * (N - i);
            ans = Math.max(ans, temp);
        }
        System.out.println(ans);

    }


}


