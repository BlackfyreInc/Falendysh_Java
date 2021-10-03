import java.util.Scanner;

public class aud_3_13 {
    public static void main(String[] args) {
        System.out.println("Input number from 0 to 10000");
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        double buffer_number = number * number;
        number = buffer_number * buffer_number * buffer_number * buffer_number;
        System.out.printf("%20.4f", number);
    }
}
