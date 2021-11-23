import java.util.Scanner;

public class hw11_str1_28 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] str_array = str.toCharArray();
        int start_index = 0;
        int end_index = str.length() - 1;
        String result = str;
        while (true){
            if (start_index >= end_index){
                break;
            }
            if (str_array[start_index] == str_array[end_index]){
                result = str.substring(start_index + 1, end_index);
                start_index += 1;
                end_index -= 1;
                if ((start_index == end_index) && (result.length() == 1) && (str_array[start_index] == str_array[str.length()/2])){
                    result = "";
                }
            }
            else{
                break;
            }
        }
        System.out.println(result);
    }
}
