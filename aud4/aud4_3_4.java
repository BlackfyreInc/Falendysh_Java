import java.util.Scanner;

public class lab3_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inp1 = Integer.parseInt(args[0]);int inp2 = Integer.parseInt(args[1]);int inp3 = Integer.parseInt(args[2]);
        if (inp1 == inp2 & inp1 == inp3){
            System.out.println("3 numbers are equal");
        }
        else if(inp1 == inp2 | inp1 == inp3 | inp2 == inp3 ){
            System.out.println("2 numbers are equal");
        }
        else{
            System.out.println("0 numbers are equal");
        }

    }
}