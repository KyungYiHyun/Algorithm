import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double dist = calcDistance(x1, y1, x2, y2);
            if (x1 == x2 && y1 == y2) {
                if (r1 == r2) System.out.println(-1);
                else {
                    System.out.println(0);
                }
            } else {
                if (dist == r1 + r2 || dist == Math.abs(r2 - r1)) {
                    System.out.println(1);
                } else if (dist < r1 + r2 && dist > Math.abs(r2 - r1)) {
                    System.out.println(2);
                } else {
                    System.out.println(0);
                }
            }

        }


    }

    public static double calcDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }


}