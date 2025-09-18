import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int[] count = new int[10];

        // 각 숫자 카운트
        for (int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';
            count[num]++;
        }

        // 6과 9는 공유 가능
        int sixNine = count[6] + count[9];
        count[6] = (sixNine + 1) / 2; // 올림 처리
        count[9] = 0; // 9는 더 이상 필요 없음

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = Math.max(ans, count[i]);
        }

        System.out.println(ans);
    }
}
