import java.util.Scanner;
import java.lang.Math;

public class lab4_20a {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double e = 0.0001;
        int x = in.nextInt();
        double sum = 0;int i = 0;double tes = x;

        while ((tes >= e)||(tes <= -e)){
            sum = sum + tes;
            tes = tes*(-1);
            tes = tes * (Math.pow(x,2));
            i = i + 2;
            tes = tes / (i*(i+1));
        }

        System.out.println(sum);
    }
}