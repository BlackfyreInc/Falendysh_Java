import classes.Point;
import java.util.Scanner;

public class hw8_4_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter quantity of vectors: ");
        int m = in.nextInt();
        Vector[] vectors = new Vector[m];
        for (int i=0;i<m;i++){
            System.out.println("Enter 3 beginning point coordinates: ");
            double x1 = in.nextDouble();
            double y1 = in.nextDouble();
            double z1 = in.nextDouble();
            System.out.println("Enter 3 ending point coordinates: ");
            double x2 = in.nextDouble();
            double y2 = in.nextDouble();
            double z2 = in.nextDouble();
            System.out.println("Enter 3 direction point coordinates: ");
            double x_dir = in.nextDouble();
            double y_dir = in.nextDouble();
            double z_dir = in.nextDouble();
            Point p_b = new Point(x1,y1,z1);
            Point p_e = new Point(x2,y2,z2);
            Point p_d = new Point(x_dir, y_dir, z_dir);
            Vector v = new Vector(p_b,p_e,p_d);
            vectors[i] = v;
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
                    if (vectors[i].complanar(vectors[j], vectors[k])){
                        System.out.printf("%d, %d, %d  vector are complanar",i,j,k);
                        System.out.println("\n");
                    }
                    else{
                        System.out.printf("%d, %d, %d vector are not complanar",i,j,k);
                        System.out.println("\n");
                    }
                }
            }
        }
    }
}
