import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            Stack<Character> words = new Stack<>();
            String word = br.readLine();
            if (word.length() % 2 == 1) {
                continue;
            }
            for (int j = 0; j < word.length(); j++) {
                if (!words.isEmpty() && words.peek() == word.charAt(j)) {
                    words.pop();
                } else {
                    words.add(word.charAt(j));
                }
            }

            if (words.isEmpty()) {
                ans++;
            }

        }
        System.out.println(ans);


    }


}
