import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int sum1 = 0;
    static int N;

    static int DIVIDE_NUM = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int a1 = 1;
        int a2 = 1;

        if (N == 1 || N == 2) {
            sum1 = 1;
        } else {
            for (int i = 3; i < N + 1; i++) {
                sum1 = (a1 + a2) % DIVIDE_NUM;
                a1 = a2;
                a2 = sum1;
            }
        }


        System.out.print(sum1 + " ");
        System.out.print((N - 2) % DIVIDE_NUM);


    }


}
