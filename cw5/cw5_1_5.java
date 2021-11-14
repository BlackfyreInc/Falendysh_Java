import java.util.Scanner;

public class cw5_1_5 {
    public static double dist(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1) + (z2 - z1) * (z2 - z1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter x: ");
        double x = in.nextDouble();
        System.out.println("Enter y: ");
        double y = in.nextDouble();
        System.out.println("Enter z: ");
        double z = in.nextDouble();

        System.out.println("Num of points ?=  ");
        int n = in.nextInt();
        double[] x_arr = new double[n];
        double[] y_arr = new double[n];
        double[] z_arr = new double[n];

        for(int i=0; i<n; i++){
            System.out.printf("Enter x №%d: ", i);
            x_arr[i] = in.nextDouble();
            System.out.printf("Enter y №%d: ", i);
            y_arr[i] = in.nextDouble();
            System.out.printf("Enter z №%d: ", i);
            z_arr[i] = in.nextDouble();
        }

        double max_dist = 0;
        int max_ind = 0;
        for(int i=0; i<n; i++){
            double distance = dist(x, y, z, x_arr[i], y_arr[i], z_arr[i]);
            if(distance > max_dist){
                max_dist = distance;
                max_ind = i;
            }
        }
        System.out.println(max_dist);
        System.out.printf("Closest to your point A is point (%f, %f, %f)", x_arr[max_ind], y_arr[max_ind], z_arr[max_ind]);
    }
}
