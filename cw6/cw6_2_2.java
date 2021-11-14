public class cw6_2_2 {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.matrix_random();
        matrix.print();
        matrix.cycle_shift("down", 2);
        matrix.cycle_shift("up", 4);
        matrix.cycle_shift("right", 1);
        matrix.cycle_shift("left", 3);
    }
}
