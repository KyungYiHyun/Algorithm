import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        while (N-- > 0) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        int cri = 0;
        for (String s : map.keySet()) {
            Integer i = map.get(s);
            if (i > cri) {
                ans.clear();
                ans.add(s);
                cri = i;
            } else if (i == cri) {
                ans.add(s);
            }
        }

        Collections.sort(ans);
        System.out.println(ans.get(0));
    }


}
