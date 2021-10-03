public class aud_1_6 {
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += Double.valueOf(args[i]);
        }
        System.out.println("sum=" + sum);
    }
}
