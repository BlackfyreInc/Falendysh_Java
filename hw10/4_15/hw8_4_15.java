import classes.Point;

import java.util.InputMismatchException;
import java.util.Scanner;

public class hw8_4_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter quantity of vectors: ");
        int m;
        Vector[] vectors;
        while (true) {
            try {
                m = in.nextInt();
                vectors = new Vector[m];
                break;
            } catch (InputMismatchException | NegativeArraySizeException | TypeNotPresentException e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i=0;i<m;i++){
            double x1, x2, x_dir, y_dir, y1, y2, z2, z1, z_dir;
            while (true) {
                try {
                    System.out.println("Enter 3 beginning point coordinates: ");
                    x1 = in.nextDouble();
                    y1 = in.nextDouble();
                    z1 = in.nextDouble();
                    System.out.println("Enter 3 ending point coordinates: ");
                    x2 = in.nextDouble();
                    y2 = in.nextDouble();
                    z2 = in.nextDouble();
                    System.out.println("Enter 3 direction point coordinates: ");
                    x_dir = in.nextDouble();
                    y_dir = in.nextDouble();
                    z_dir = in.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
            }
            Point p_b = new Point(x1,y1,z1);
            Point p_e = new Point(x2,y2,z2);
            Point p_d = new Point(x_dir, y_dir, z_dir);
            Vector v = new Vector(p_b,p_e,p_d);
            try {
                vectors[i] = v;
            } catch (ArrayStoreException e) {
                System.out.println(e.getMessage());
            }
        }

        for (int i=0;i<m;i++){
            for (int j=1;j<m;j++){
                if (i==j){
                    continue;
                }
                for (int k=2;k<m;k++){
                    if ((j==k)||(i==k)) {
                        continue;
                    }
                    try {
                        if (vectors[i].complanar(vectors[j], vectors[k])) {
                            System.out.printf("%d, %d, %d  vector are complanar", i, j, k);
                            System.out.println("\n");
                        } else {
                            System.out.printf("%d, %d, %d vector are not complanar", i, j, k);
                            System.out.println("\n");
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
