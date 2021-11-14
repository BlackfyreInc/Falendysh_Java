import java.util.Scanner;

public class cw5_1_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] str_array = s.split(" ");
        int[] array = new int[str_array.length];

        for(int i=0; i<array.length; i++){
            array[i] = Integer.parseInt(str_array[i]);
        }

        int max_len = 1, tm = 1, most_pop_num = 0;
        for(int i=1; i<array.length; i++){
            if (array[i] != array[i-1]){
                if (max_len < tm){
                    max_len = tm;
                    most_pop_num = array[i-1];
                }
                tm = 1;
            }
            else tm++;
        }
        System.out.println(max_len + "подряд чисел " + most_pop_num);
    }
}

