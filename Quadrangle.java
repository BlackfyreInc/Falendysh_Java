import java.util.Scanner;

public class Quadrangle {
    double edge1, edge2, edge3, edge4;
    double angle1, angle2, angle3, angle4, angled;
    double d1, d2;

    public Quadrangle(double ab, double bc, double cd, double ad, double a, double b, double c, double d){
        edge1=ab;
        edge2=bc;
        edge3=cd;
        edge4=ad;
        angle1=a;
        angle2=b;
        angle3=c;
        angle4=d;
    }

    public void getDiag(){
        System.out.println("Enter diagonals for your quadrangle and angle between them in line: ");
        Scanner inp = new Scanner(System.in);
        double dia1 = inp.nextDouble(); double dia2 = inp.nextDouble(); double dd = inp.nextDouble();
        d1=dia1; d2=dia2; angled=dd;
    }

    public boolean is_square(){
        return (this.edge1 == this.edge2) && (this.edge1 == this.edge3) && (this.edge1 == this.edge4) && (this.angle1 == 90) && (this.angle1 == this.angle3);
    }

    public boolean is_rectangle(){
        return (this.edge1 == this.edge3) && (this.edge2 == this.edge4) && (this.angle1 == 90) && (this.angle1 == this.angle3);
    }

    public boolean is_rhombus(){
        return (this.edge1 == this.edge2) && (this.edge1 == this.edge3) && (this.edge1 == this.edge4) && (this.angle1 != 90) && (this.angle1 == this.angle3) && (this.angle2 == this.angle4);
    }

    public double perimeter(){
        return (this.edge1 + this.edge2 + this.edge3 + this.edge4);
    }

    public double area(){
        if (this.is_square()){
            return (this.edge1 * this.edge1);
        }
        else if (this.is_rectangle()){
            return (this.edge1 * this.edge2);
        }
        else if (this.is_rhombus()){
            return (this.edge1 * this.edge1 * Math.sin(this.angle1));
        }
        else{
            return (this.d1 * this.d2 * this.angled);
        }
    }

    public void printt(){
        if (this.is_square()){
            System.out.printf("Square of edge: %f \n", this.edge1);
        }
        else if (this.is_rectangle()){
            System.out.printf("Rectangle of edges: %f, %f \n", this.edge1, this.edge2);
        }
        else if (this.is_rhombus()){
            System.out.printf("Rhombus of edge: %f \n", this.edge1);
        }
        else{
            System.out.printf("Quadrangle of edges: %f, %f, %f, %f \n", this.edge1, this.edge2, this.edge3, this.edge4);
        }
    }
}
