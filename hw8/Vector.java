import classes.Point;

public class Vector {
    double x, y, z;
    Point v_direction;

    public Vector(Point a, Point b, Point c) {
        x = b.getX() - a.getX();
        y = b.getY() - a.getY();
        z = b.getZ() - a.getZ();
        double x_vd = c.getX();
        double y_vd = c.getY();
        double z_vd = c.getZ();
        v_direction = new Point(x_vd, y_vd, z_vd);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public boolean is_ort(Vector other) {
        double scalprod = this.x * other.x + this.y * other.y + this.z * other.z;
        return scalprod == 0;
    }

    public void compare(Vector a, Vector b) {
        if ((a.length() == b.length()) & (a.v_direction.point_equality(b.v_direction))) {
            System.out.println("First vector == Second vector");
        }
        else{
            System.out.println("First vector != Second vector ");
        }
    }

    public double mixed_product(Vector b, Vector c){
        return ((this.x * b.y * c.z) + (this.y * b.z * c.x) + (this.z * b.x * c.y) - (this.z * b.y * c.x) - (this.y * b.x * c.z) - (this.x * b.z * c.y));
    }

    public boolean complanar(Vector b, Vector c) {
        return mixed_product(b, c) == 0;
    }

    public void is_intersect(Vector a, Vector b, Vector middle){
        if (mixed_product(b, middle) == 0){
            System.out.println("Vectors intersect");
        }
        else{
            System.out.println("Vectors do not intersect");
        }
    }
}
