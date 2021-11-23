package cw8;
import java.util.Scanner;

public class cw8_3_1 {
    public static Rational add(Rational x, Rational y) {
        return new Rational(x.n * y.m + y.n * x.m, x.m * y.m);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter N:");
        int num = in.nextInt(), n, m;
        in.nextLine();
        Rational[] num_arr = new Rational[num];
        for (int i = 0; i < num; i++) {
            System.out.println("Enter m:");
            n = in.nextInt();
            System.out.println("Enter n:");
            m = in.nextInt();
            Rational temp = new Rational(n, m);
            num_arr[i] = temp;
        }


        for (int a = 0; a < num; a++) {
            num_arr[a].get_ratio();
        }


        Rational sum = new Rational(0,1);
        for(int b = 0; b < num; b++){
            sum = add(sum,num_arr[b]);
        }
        sum.get_ratio();
    }
}
