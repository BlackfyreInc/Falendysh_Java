import java.io.*;

public class cw12_tx_1 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/file1.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String text = "";
        String line;
        while ((line = br.readLine()) != null) {
            text += line + " ";
        }
        System.out.println(text);

        String[] words = text.split(" ");
        int len = words.length;

        String max_w = "";
        for (String s: words){
            if (max_w.length() < s.length()) max_w = s;
        }

        FileWriter fileWriter = new FileWriter(file);
        text = text.replaceAll("  ", " ");
        text = text.replaceAll("  ", " ");
        for(String word: words){
            if (word.length() == 1) text = text.replace(" " + word + " ", " ");
        }
        fileWriter.write(text);
        fileWriter.close();

        String text1 = text;
        if (text1.charAt(0) == ' ') text1 = text1.replace(" ", "");
        FileWriter fileWriter1 = new FileWriter(file);
        for(String word: words){
            if (word.length() == 1) text = text.replace(" " + word + " ", " ");
        }
        fileWriter1.write(text);
        fileWriter1.close();


        System.out.println("a) " + max_w);
        System.out.println("б) " + len);
        System.out.println("в) " + text);
        System.out.println("г) " + text1);
    }
}
