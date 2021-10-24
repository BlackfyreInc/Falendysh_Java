
public class hw5_1_23 {
    public static void main(String[] args) {
        int isbn_9 = Integer.parseInt(args[0]);
        String ibn_9 = String.format("%09d", isbn_9);
        System.out.println(ibn_9);
        String[] ibn_num = ibn_9.split("");
        int[] ibn_int;
        ibn_int = new int[ibn_num.length];
        for (int i = 0; i<ibn_num.length; i++){
            if (ibn_num[i].equals("X")){
                ibn_num[i] = "10";
            }
            ibn_int[i] = Integer.parseInt(ibn_num[i]);
        }
        int sum_9 = 2*ibn_int[8] + 3*ibn_int[7] + 4*ibn_int[6] + 5*ibn_int[5] + 6*ibn_int[4] + 7*ibn_int[3] + 8*ibn_int[2] + 9*ibn_int[1] + 10*ibn_int[0];
        int d1 = 11-(sum_9%11);
        System.out.println(d1);
        String d;
        if (d1 == 10){
            d = "X";
        } else{
            d = ""+d1;
        }
        System.out.println(ibn_9+d);


    }
}
