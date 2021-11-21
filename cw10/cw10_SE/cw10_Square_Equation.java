package cw10_SE;

import java.util.InputMismatchException;
import java.util.Scanner;

public class cw10_Square_Equation {
    public static void main(String[] args) {
        double a, b, c;

        Scanner in = new Scanner(System.in);

        try {
            SquareEquation squareEquation = new SquareEquation(2, -6, 4);
            squareEquation.solution();
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

        try {
            SquareEquation squareEquation1 = new SquareEquation(1, 2, 3);
            squareEquation1.solution();
        } catch (Discriminant_Exception e) {
            System.out.println(e);
        }

        try {
            SquareEquation squareEquation2 = new SquareEquation(0, 2, 3);
            squareEquation2.solution();
        } catch (Zero_Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("Enter a, b, c:");
            a = in.nextDouble();
            b = in.nextDouble();
            c = in.nextDouble();

            SquareEquation squareEquation3 = new SquareEquation(a, b, c);
            squareEquation3.solution();
            squareEquation3.printRoots();
        }
        catch (InputMismatchException e) {
            System.out.println(e);
        }
    }
}
