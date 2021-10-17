import java.util.Scanner;

public class aud5_1_2{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] array = s.split(" ");
        int max = -2147483647;
        int min = 2147483647;
        for (String a : array){
            int an = Integer.parseInt(a);
            if (an > max) max = an;
            if (an < min) min = an;
        }
        System.out.println(max);
        System.out.println(min);
    }
}