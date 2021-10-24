import java.util.Scanner;

public class aud5_1_3{
    public static double mean(double[] m) {
        double sum = 0;
        for (double j : m)
            sum += j;
        return sum / m.length;
    }

    public static double SDfun(double[] m) {
        double  sdev = 0.0;
        double mean = mean(m);

        for(double num: m)
            sdev += Math.pow(num - mean, 2);

        return Math.sqrt(sdev / m.length);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] array = new double[n];
        for(int i=0; i<n; i++){
            double a = in.nextDouble();
            array[i] = a;
        }
        System.out.println(mean(array));
        System.out.println(SDfun(array));

    }
}