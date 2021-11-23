import java.io.*;
import java.util.Scanner;

public class hw12_14 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        File file = new File("src/file1.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String text = "";
        String line;
        while ((line = br.readLine()) != null) {
            text += line + " ";
        }

        String[] words = text.split(" ");
        System.out.println("Available surnames and initials");
        for (int i=0;i< words.length;i+=3){
            System.out.println(words[i] + " " + words[i+1]);
        }
        System.out.println("Enter surname you want to find phone number for: ");
        String surn = in.nextLine();
        System.out.println("Enter initials you want to find phone number for:");
        String initials = in.nextLine();
        int ans = 0;
        for (int i=1;i<words.length;i++){
            if ((words[i-1].equals(surn)) && (words[i].equals(initials))){
                ans = i+1;
            }
        }

        if (ans == 0){
            throw new Exception("Entered data is not in the file");
        }
        System.out.println(words[ans]);
    }
}
