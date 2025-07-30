import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            BigInteger left = new BigInteger(st.nextToken());
            BigInteger right = new BigInteger(st.nextToken());
            int temp = left.intValue();


            BigInteger top = new BigInteger("1");
            BigInteger down = new BigInteger("1");

            for (int i = 0; i < temp; i++) {
                top = top.multiply(right);
                right = right.subtract(BigInteger.ONE);
                down = down.multiply(left);
                left = left.subtract(BigInteger.ONE);

            }

            System.out.println(top.divide(down));


        }


    }
}