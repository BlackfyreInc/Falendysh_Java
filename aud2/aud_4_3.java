public class aud_4_3 {
    public static void main(String[] args) {
        double a1 = 5678.43;
        double a2 = 4567.56;
        System.out.println(Rosenbrock2d(a1, a2));

        double a3 = 5678.43;
        double a4 = 4567.56;
        System.out.println(Rosenbrock2d(a3, a4));

        double a5 = 5678.43;
        double a6 = 4567.56;
        System.out.println(Rosenbrock2d(a5, a6));
    }

    public static double Rosenbrock2d(double x, double y) {
        return 100 * (Math.pow(x, 2) - Math.pow(y, 2)) + Math.pow(((x - 1)), 2);
    }
}
