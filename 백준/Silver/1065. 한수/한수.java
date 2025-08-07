import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        ArrayList<Integer> nums = new ArrayList<>();
        int ans = 0;

        int iteration = Integer.parseInt(s);
        for (int i = 1; i < iteration + 1; i++) {
            String s2 = String.valueOf(i);
            if (s2.length() == 1) {
                ans++;
                continue;
            }
            int divideNum = (int) Math.pow(10, s2.length() - 1);
            int target = Integer.parseInt(s2);
            for (int j = 0; j < s2.length(); j++) {
                nums.add(target / divideNum);
                target %= divideNum;
                divideNum /= 10;
            }

            int diff = nums.get(1) - nums.get(0);
            boolean flag = true;
            for (int k = 2; k < nums.size(); k++) {
                int temp = nums.get(k) - nums.get(k - 1);
                if (temp != diff) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
            nums.clear();


        }

        System.out.println(ans);


    }


}