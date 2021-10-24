import java.util.Scanner;

public class hw {
    /**
     * <p>
     *     F to C
     *     Console output
     * </p>
     * @param args array of strings
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Фалендыш, 2.4");
        System.out.print("Введите градусы по Цельсию: ");
        float C = in.nextFloat();
        float F = 9*C/5 + 32;
        System.out.printf("F = %.2f", F);
        in.close();
    }
}
