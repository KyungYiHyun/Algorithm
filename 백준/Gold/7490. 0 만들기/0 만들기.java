import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {

    static char[] unit = {'+', '-', '.'};
    static ArrayList<ArrayList<Character>> result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        ArrayList<Integer> nums = new ArrayList<>();
        result = new ArrayList<>();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= n; i++) {
                nums.add(i);
            }
            perm(0, n, new ArrayList<>(), result);
            StringBuilder sb = new StringBuilder();
            StringBuilder display = new StringBuilder();
            List<String> answer = new ArrayList<>();
            for (int i = 0; i < result.size(); i++) {
                sb.append(nums.get(0));
                display.append(nums.get(0));
                for (int j = 0; j < result.get(i).size(); j++) {
                    if (result.get(i).get(j).equals('.')) {
                        sb.append(nums.get(j + 1));
                        display.append(' ');
                        display.append(nums.get(j + 1));
                    } else {
                        sb.append(result.get(i).get(j));
                        sb.append(nums.get(j + 1));
                        display.append(result.get(i).get(j));
                        display.append(nums.get(j + 1));
                    }
                }


                int cur = 0;
                int sum = 0;
                char a = '+';
                for (int k = 0; k < sb.length(); k++) {
                    if (sb.charAt(k) == '+') {
                        if (a == '+') {
                            sum += cur;
                        } else {
                            sum -= cur;
                        }
                        cur = 0;
                        a = '+';
                    } else if (sb.charAt(k) == '-') {
                        if (a == '+') {
                            sum += cur;
                        } else {
                            sum -= cur;
                        }
                        cur = 0;
                        a = '-';
                    } else {
                        cur = cur * 10 + Integer.parseInt(String.valueOf(sb.charAt(k)));
                    }
                }
                if (a == '+') {
                    sum += cur;
                } else {
                    sum -= cur;
                }

                if (sum == 0) {
                    answer.add(display.toString());
                }
                sb = new StringBuilder();
                display = new StringBuilder();
                Collections.sort(answer);
            }
            for (String s : answer) {
                System.out.println(s);
            }
            System.out.println();
            nums.clear();
            result.clear();
        }


    }

    private static void perm(int depth, int n, ArrayList<Character> temp, ArrayList<ArrayList<Character>> result) {
        if (depth == n - 1) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < 3; i++) {
            temp.add(unit[i]);
            perm(depth + 1, n, temp, result);
            temp.remove(temp.size() - 1);
        }

    }
}





