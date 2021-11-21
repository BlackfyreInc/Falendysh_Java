package cw8;

import java.util.Scanner;

public class cw8_4_1 {

    public static Rational add(Rational x, Rational y) {
        return new Rational(x.n * y.m + y.n * x.m, x.m * y.m);
    }

    public static Polynom sum(Polynom x,Polynom y){
        Polynom answer = new Polynom();
        if(x.coef.length >= y.coef.length) {
            answer = x;
            for(int i = 0; i < y.coef.length;i++){
                answer.coef[i] = add(x.coef[i],y.coef[i]);
            }
        }
        else{
            answer = y;
            for(int i = 0; i < x.coef.length;i++){
                answer.coef[i] = add(x.coef[i],y.coef[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter N:");
        int n = inp.nextInt();
        Polynom[] poly_arr = new Polynom[n];
        int m;
        for (int i = 0;i < n;i++){
            System.out.println("Enter length of your polynom: ");
            m = inp.nextInt();
            Rational[] test = new Rational[m];
            for(int j = 0; j < m; j++){
                System.out.println("Enter a:");
                int a = inp.nextInt();
                System.out.println("Enter b:");
                int b = inp.nextInt();
                Rational temp = new Rational(a, b);
                test[j] = temp;
            }
            poly_arr[i] = new Polynom(test);
        }
        for(int i = 0;i < n;i++){
            poly_arr[i].get_poly();
        }
        System.out.println("\n");
        Rational[] nul = new Rational[0];
        Polynom sum = new Polynom(nul);
        for(int b = 0; b < n; b++){
            sum = sum(sum,poly_arr[b]);
        }
        sum.get_poly();
    }
}
