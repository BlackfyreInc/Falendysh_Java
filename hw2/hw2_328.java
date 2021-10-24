import java.util.Scanner;

public class hw2_328 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double r = in.nextDouble();
        double R = in.nextDouble();
        double V = 2*R*r*r*Math.PI*Math.PI;
        System.out.println("Объем = " + V);
    }
}
