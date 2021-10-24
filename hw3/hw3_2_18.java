import java.util.Scanner;

public class hw3_2_18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        b--;
        int c;
        c = 1 << b;
        a = a ^ c;
        System.out.println(a + " " +Integer.toString(a, 16)+ " " +Integer.toString(a, 2));
    }
}
