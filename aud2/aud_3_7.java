import java.util.Scanner;

public class aud_3_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input m1:");
        double m1 = sc.nextDouble();
        System.out.println("input m2:");
        double m2 = sc.nextDouble();
        System.out.println("input r:");
        double r = sc.nextDouble();
        double y = 0.673e-12;
        double F = y * (m1 * m2) / Math.pow(r, 2);
        System.out.printf("F=%e", F);
    }
}
