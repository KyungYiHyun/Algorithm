import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        boolean[] check = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int cal = cal(i);
            if (cal < 10001) {
                check[cal] = true;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }

    private static int cal(int i) {
        int temp = i;

        while (i > 0) {
            temp += i % 10;
            i /= 10;
        }

        return temp;

    }


}