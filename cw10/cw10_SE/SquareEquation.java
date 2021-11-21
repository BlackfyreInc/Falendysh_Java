package cw10_SE;
public class SquareEquation {
    private double a, b, c, x1, x2;

    SquareEquation() {}

    SquareEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double discriminant() throws Discriminant_Exception {
        double d = b*b - 4*a*b;

        if (d < 0) {
            throw new Discriminant_Exception("Your discriminant is invalid!", a, b, c, d);
        }
        return d;
    }

    public void solution() throws Discriminant_Exception, Zero_Exception {
        try {
            if (a == 0) throw new Zero_Exception("First member equals zero");

            double d = discriminant();
            double x1 = (-b - Math.sqrt(d))/(2*a);
            double x2 = (-b + Math.sqrt(d))/(2*a);

            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
            this.x1 = x1;
            this.x2 = x2;

        } catch (Zero_Exception e) {
            System.out.println(e);
            throw new Zero_Exception("Division by 0.");
        } catch (Discriminant_Exception e) {
            throw e;
        }
    }

    public void printRoots() {
        System.out.println("Equation's roots: x1 = " + x1 + ", x2 = " + x2);
    }
}
