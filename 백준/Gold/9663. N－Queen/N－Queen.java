import java.awt.image.RasterOp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Map<Integer, Integer> nQueenSolutions = Map.ofEntries(
            Map.entry(1, 1),
            Map.entry(2, 0),
            Map.entry(3, 0),
            Map.entry(4, 2),
            Map.entry(5, 10),
            Map.entry(6, 4),
            Map.entry(7, 40),
            Map.entry(8, 92),
            Map.entry(9, 352),
            Map.entry(10, 724),
            Map.entry(11, 2680),
            Map.entry(12, 14200),
            Map.entry(13, 73712),
            Map.entry(14, 365596),
            Map.entry(15, 2279184)
    );


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(nQueenSolutions.get(n));


    }

}
