import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            int answerShort = 10001;
            int answerLong = 0;
            String s = br.readLine();
            int W = Integer.parseInt(br.readLine());
            for (int l = 0; l < s.length(); l++) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);
            }

            if (W == 1) {
                System.out.print(1 + " ");
                System.out.println(1);
                continue;
            }

            for (int j = 0; j < s.length(); j++) {
                char temp = s.charAt(j);
                if (map.get(temp) < W) {
                    continue;
                }
//                System.out.println("temp = " + temp);
                int count = 1;
                for (int k = j + 1; k < s.length(); k++) {
//                    System.out.println("k = " + k);
                    if (s.charAt(k) == temp) {
//                        System.out.println("s.charAt(k) = " + s.charAt(k));
                        count++;
//                        System.out.println("count = " + count);
                        if (count == W) {
                            answerShort = Math.min(answerShort, k - j + 1);
                            answerLong = Math.max(answerLong, k - j + 1);
                            break;
                        }
                    }

                }

            }
            if (answerShort == 10001 || answerLong == 0) {
                System.out.println(-1);
            } else {
                System.out.print(answerShort + " ");
                System.out.println(answerLong);
            }

        }


    }
}