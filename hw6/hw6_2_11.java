import java.util.Scanner;

public class hw6_2_11 {
    static void clearzeroes(int[][] matrix, int n)
    {
        int[] col = new int[n + 1];
        int[] row = new int[n + 1];
        for(int i = 0; i < n; ++i)
        {
            int count = 0;
            for(int j = 0; j < n; ++j)
            {
                if (matrix[i][j] == 0){
                    col[j] += 0;
                    count += 0;
                }
                else {
                    col[j] += 1;
                    count += 1;
                }
            }
            row[i] = count;
        }
        for(int i = 0; i < n; ++i)
        {
            if (row[i] == 0) {continue;}
            for(int j = 0; j < n; ++j)
            {
                if (col[j] != 0)
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите разряд матрицы: ");
        int n = in.nextInt();
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Введите элемент №: %d строки №: %d: ", i, j);
                m[i][j] = in.nextInt();
            }
        }

        clearzeroes(m, n);
    }
}