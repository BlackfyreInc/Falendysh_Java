import java.util.Scanner;

public class hw4_4_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inp1 = Integer.parseInt(args[0]);
        int inp2 = Integer.parseInt(args[1]);
        int inp3 = Integer.parseInt(args[2]);
        if (inp1 == inp2 & inp1 == inp3) {
            System.out.println("Equal");
        } else {
            System.out.println("Unequal");
        }
    }
}