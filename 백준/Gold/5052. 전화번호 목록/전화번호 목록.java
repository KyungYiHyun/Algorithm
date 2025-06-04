import java.awt.image.RasterOp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                set.add(input);
            }

            boolean solve = solve(set);
            if (solve) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }


        }
    }

    private static boolean solve(HashSet<String> set) {
        for (String s : set) {
            int length = s.length();
            for (int i = 0; i < length; i++) {
                if (set.contains(s.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}

