import java.util.Scanner;

public class cw5_1_3 {
    static void MeanAndSSD(double arr[])
    {
        double sum=0;
        int n = arr.length;
        for (double v : arr) {
            sum = sum + v;
        }
        double mean=sum/n;
        System.out.println("Mean =  " + mean);
        sum=0;
        for (double v : arr) {
            sum += Math.pow((v - mean), 2);
        }
        mean=sum/(n-1);
        double deviation=Math.sqrt(mean);
        System.out.println("Sample standard deviation = " + deviation);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] array = new double[n];
        for(int i=0; i<n; i++){
            double a = in.nextDouble();
            array[i] = a;
        }
        MeanAndSSD(array);
    }
}

