import java.awt.image.RasterOp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static boolean flag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(T);
        solve(sb, S, S.length());
        if (!flag) {
            System.out.println(0);
        }

    }

    private static void solve(StringBuilder args, String ans, int len) {
        if (args.toString().equals(ans)) {
            flag = true;
        }

        if (flag) {
            System.out.println(1);
            System.exit(0);
        }

        if (args.toString().length() < len) {
            return;
        }
        if (args.charAt(args.length() - 1) == 'A') {
            solve(args.deleteCharAt(args.length() - 1), ans, len);
            args.append("A");
        }

        if (args.charAt(args.length() - 1) == 'B') {
            solve(args.deleteCharAt(args.length() - 1).reverse(), ans, len);
            args.reverse().append("B");
        }


    }

}
