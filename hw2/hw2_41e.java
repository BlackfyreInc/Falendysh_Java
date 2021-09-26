import java.util.Scanner;

public class hw2_41e {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt(), x2 = x*x*x, x3 = x2*x*x;
        System.out.println("y = " + (x + x2+ x3));
    }
}
