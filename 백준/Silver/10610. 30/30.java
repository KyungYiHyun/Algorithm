import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        char[] charArray = N.toCharArray();
        Arrays.sort(charArray);

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = N.length() - 1; i >= 0; i--) {
            sb.append(charArray[i]);
            sum += Character.getNumericValue(charArray[i]);
        }

  
        if (sum % 3 != 0 || charArray[0] != '0') {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }


    }


}
