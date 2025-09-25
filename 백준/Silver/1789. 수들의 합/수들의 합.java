import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long sum = 0;
        long cnt = 0;
        if (S == 1){
            System.out.println(1);
            return;
        }
        for (long i = 1; i <= S; i++) {
            if (sum > S) break;
            sum += i;
            cnt++;
        }
        System.out.println(cnt - 1);

    }
}
