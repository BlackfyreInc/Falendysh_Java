import java.util.Scanner;
import java.lang.Math;

public class hw4_4_20d {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double e = 0.0001;
        int x = in.nextInt();
        double sum = 0;
        int i = 0;
        double tes = x;

        while ((tes >= e) || (tes <= -e)) {
            sum = sum + tes;
            tes = tes * x;
            i = i + 1;
            tes = tes / (i * i);
        }
        System.out.println(sum);
    }
}
