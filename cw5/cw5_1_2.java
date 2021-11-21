import java.util.Scanner;

public class cw5_1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] str_array = str.split(" ");
        int max = -2147483647;
        int min = 2147483647;
        for (String s : str_array){
            int tm = Integer.parseInt(s);
            if (tm > max) {max = tm;}
            if (tm < min) {min = tm;}
        }
        System.out.println(min);
        System.out.println(max);
    }
}
