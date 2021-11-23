import java.util.Scanner;

public class hw11_str2_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String myString = in.nextLine();
        int largestSequence = 0;
        char longestChar = ' ';

        int currentSequence = 1;
        char current = ' ';
        char next = ' ';

        for (int i = 0; i < myString.length() - 1; i++) {
            current = myString.charAt(i);
            next = myString.charAt(i + 1);

            if (current == next) {
                currentSequence += 1;
            }
            else {
                if (currentSequence > largestSequence) {
                    largestSequence = currentSequence;
                    longestChar = current;
                }
                currentSequence = 1;
            }
        }
        if (currentSequence > largestSequence) {
            largestSequence = currentSequence;
            longestChar = current;
        }

        System.out.println(longestChar + ": " + largestSequence);

    }
}
