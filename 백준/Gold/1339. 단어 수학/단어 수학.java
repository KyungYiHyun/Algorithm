import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int len = s.length();
            for (int j = 0; j < len; j++) {
                int weight = (int) Math.pow(10, len - j - 1);
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + weight);
            }
        }
        
        ArrayList<Integer> weights = new ArrayList<>(map.values());
        Collections.sort(weights, Collections.reverseOrder());

        int num = 9;

        for (int i = 0; i < weights.size(); i++) {
            ans += num * weights.get(i);
            num--;
        }


        System.out.println(ans);


    }


}
