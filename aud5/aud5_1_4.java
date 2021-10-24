import java.util.Scanner;

public class aud5_1_4{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] arrays = s.split(" ");
        int[] array = new int[arrays.length];
        for(int i=0; i<array.length; i++){
            array[i] = Integer.parseInt(arrays[i]);
        }

        int maxlen = 1;
        int len = 1;
        int n = 0;

        for(int i=1; i<array.length; i++){
            if (array[i] != array[i-1]){
                if (maxlen < len){
                    maxlen = len;
                    n = array[i-1];
                }
                len = 1;
            }
            else len++;
        }
        System.out.println(maxlen);
        System.out.println(n);
    }
}