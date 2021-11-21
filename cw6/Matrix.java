import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    int[][] matrix;
    int dim;
    Scanner console;

    Matrix() {
        this.console = new Scanner(System.in);
        System.out.println("enter dimension of the matrix: ");
        this.dim = console.nextInt();
        this.matrix = new int[dim][dim];
    }

    void matrix_random() {
        Random random = new Random();
        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < this.dim; j++) {
                this.matrix[i][j] = random.nextInt(10);
            }
        }
    }

    void matrix_enter() {
        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < this.dim; j++) {
                System.out.printf("enter x%d y%d: ", i, j);
                this.matrix[i][j] = console.nextInt();
            }
        }
    }

    void print() {
        System.out.println();
        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < this.dim; j++) {
                System.out.printf("%d ", this.matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    void cycle_shift(String direction, int k) {
        k = k % this.dim;
        int[][] new_matrix = new int[this.dim][this.dim];
        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < this.dim; j++) {
                if (Objects.equals(direction, "down")) new_matrix[i][j] = this.matrix[(i + this.dim - k) % this.dim][j];
                if (Objects.equals(direction, "up")) new_matrix[i][j] = this.matrix[(i + k) % this.dim][j];
                if (Objects.equals(direction, "right")) new_matrix[i][j] = this.matrix[i][(j + k) % this.dim];
                if (Objects.equals(direction, "left")) new_matrix[i][j] = this.matrix[i][(j + this.dim - k) % this.dim];
            }
        }
        this.matrix = new_matrix;
        print();
    }

    void sort_k(String direction, int k) {
        int[][] new_matrix = this.matrix;
        for (int i = 1; i < this.dim; i++) {
            for (int j = 1; j < this.dim; j++) {
                if (direction == "column") {
                    if (new_matrix[j][k] < new_matrix[j - 1][k]) {
                        int[] temp = new_matrix[j];
                        new_matrix[j] = new_matrix[j - 1];
                        new_matrix[j - 1] = temp;
                    }
                }
            }
        }
        this.matrix = new_matrix;
        print();
    }
}
