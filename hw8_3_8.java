import java.util.Scanner;

public class hw8_3_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of your quadrangles: ");
        int m = in.nextInt();
        Quadrangle[] quadrangles = new Quadrangle[m];
        int square_count = 0; int rectangle_count = 0;int rhombus_count = 0; int other_count = 0;
        for (int i=0;i<m;i++){
            System.out.println("Enter your quadrangle's edges in line: ");
            double ab = in.nextDouble(); double bc = in.nextDouble(); double cd = in.nextDouble(); double ad = in.nextDouble();
            System.out.println("Enter your quadrangle's angles in line: ");
            double a = in.nextDouble(); double b = in.nextDouble(); double c = in.nextDouble(); double d = in.nextDouble();
            Quadrangle q = new Quadrangle(ab,bc,cd,ad,a,b,c,d);
            quadrangles[i] = q;
        }

        for (int i=0;i<m;i++){
            if (quadrangles[i].is_square()){
                square_count += 1;
                continue;
            }
            else if (quadrangles[i].is_rectangle()){
                rectangle_count += 1;
                continue;
            }
            else if (quadrangles[i].is_rhombus()){
                rhombus_count += 1;
                continue;
            }
            else{
                other_count += 1;
            }

        }
        System.out.printf("The number of squares = %d, rectangles = %d, rhombuses = %d, other = %d \n", square_count, rectangle_count, rhombus_count, other_count);
        Quadrangle[] squares = new Quadrangle[square_count]; Quadrangle[] rectangles = new Quadrangle[rectangle_count];
        Quadrangle[] rhombuses = new Quadrangle[rhombus_count]; Quadrangle[] others = new Quadrangle[other_count];
        int s = 0; int r = 0; int rh = 0; int ot = 0;
        for (int i=0;i<m;i++){
            if (quadrangles[i].is_square()){
                squares[s] = quadrangles[i];
                s++;
                continue;
            }
            else if (quadrangles[i].is_rectangle()){
                rectangles[r] = quadrangles[i];
                r++;
                continue;
            }
            else if (quadrangles[i].is_rhombus()){
                rhombuses[rh] = quadrangles[i];
                rh++;
                continue;
            }
            else{
                others[ot] = quadrangles[i];
                ot++;
            }
        }
        int max_i1 = 0;int max_i2 = 0;
        if (square_count > 0) {
            double square_max_p = 0;
            double square_max_area = 0;

            for (int i = 0; i < square_count; i++) {
                if (squares[i].perimeter() > square_max_p) {
                    square_max_p = squares[i].perimeter();
                    max_i1 = i;
                }
                if (squares[i].area() > square_max_area) {
                    square_max_area = squares[i].area();
                    max_i2 = i;
                }
            }
            System.out.print("Square with the biggest perimeter is ");
            squares[max_i1].printt();
            System.out.print("Square with the biggest area is ");
            squares[max_i2].printt();
        }else{
            System.out.println("There are no squares");
        }
        max_i1 = 0; max_i2 = 0;
        if (rectangle_count > 0) {
            double rect_max_p = 0;
            double rect_max_area = 0;
            for (int i = 0; i < rectangle_count; i++) {
                if (rectangles[i].perimeter() > rect_max_p) {
                    rect_max_p = rectangles[i].perimeter();
                    max_i1 = i;
                }
                if (rectangles[i].area() > rect_max_area) {
                    rect_max_area = rectangles[i].area();
                    max_i2 = i;
                }
            }
            System.out.print("Rectangle with the biggest perimeter is ");
            rectangles[max_i1].printt();
            System.out.print("Rectangle with the biggest area is ");
            rectangles[max_i2].printt();
        }else{
            System.out.println("There are no rectangles");
        }
        max_i1 = 0; max_i2 = 0;
        if (rhombus_count > 0) {
            double rh_max_p = 0;
            double rh_max_area = 0;
            for (int i = 0; i < rhombus_count; i++) {
                if (rhombuses[i].perimeter() > rh_max_p) {
                    rh_max_p = rhombuses[i].perimeter();
                    max_i1 = i;
                }
                if (rhombuses[i].area() > rh_max_area) {
                    rh_max_area = rhombuses[i].area();
                    max_i2 = i;
                }
            }
            System.out.print("Rhombus with the biggest perimeter is ");
            rhombuses[max_i1].printt();
            System.out.print("Rhombus with the biggest area is ");
            rhombuses[max_i2].printt();
        }else{
            System.out.println("There are no rhombuses");
        }
        max_i1 = 0; max_i2 = 0;
        if (other_count > 0) {
            double ot_max_p = 0;
            double ot_max_area = 0;
            for (int i = 0; i < other_count; i++) {
                others[i].getDiag();
                if (others[i].perimeter() > ot_max_p) {
                    ot_max_p = others[i].perimeter();
                    max_i1 = i;
                }
                if (others[i].area() > ot_max_area) {
                    ot_max_area = others[i].area();
                    max_i2 = i;
                }
            }
            System.out.print("Quadrangle with the biggest perimeter is ");
            others[max_i1].printt();
            System.out.print("Quadrangle with the biggest area is ");
            others[max_i2].printt();
        }else{
            System.out.println("There are no other types of quadrangles here");
        }
    }
}
