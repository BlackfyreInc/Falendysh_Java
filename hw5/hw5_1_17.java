import java.util.Scanner;

public class hw5_1_17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0, b = 1000000;
        System.out.println("Answer Yes or No");

        for (int i = 1; a < b; i++) {
            int mid = a + (b - a) / 2;
            System.out.print("Question №" + i + ": ");
            System.out.println("Is your number <= " + mid + "?");
            String ans = in.nextLine();
            if (ans.equals("Yes")){
                b = mid;
            }
            else{
                a = mid + 1;
            }
        }

        System.out.println("I guess your number is " + a);
    }
}
