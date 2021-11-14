import java.util.Scanner;

public class cw5_1_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] str_array = s.split(" ");
        int min_len = 2147483647;
        for (String str: str_array){
            if (str.length() < min_len){
                min_len = str.length();
            }
        }
        for (String str: str_array){
            if (str.length() == min_len){
                System.out.println(str);
            }
        }
    }
}
