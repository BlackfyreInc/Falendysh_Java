import java.io.*;
import java.util.Scanner;

public class hw13_6 {
    public static void main(String[] args) throws IOException {
        int[] data = {5,1,2,-3,-7,-6,11,6,-9,-2};
        DataOutputStream input_F = new DataOutputStream(new FileOutputStream("src/F.bin"));
        for (int i: data){
            input_F.writeInt(i);
        }
        input_F.close();

        DataInputStream F = new DataInputStream(new FileInputStream("src/F.bin"));
        DataOutputStream G = new DataOutputStream(new FileOutputStream("src/G.bin"));

        int[] pos = new int[input_F.size()/8];
        int[] neg = new int[input_F.size()/8];
        int count_pos = 0;
        int count_neg = 0;
        try{
            for (int s=0, i=0;i<=input_F.size()/4;i++, s = F.readInt()){
                if (s > 0){
                    pos[count_pos] = s;
                    count_pos++;
                }
                else if (s < 0){
                    neg[count_neg] = s;
                    count_neg++;
                }
            }
        } catch(IOException ignored) { }

        Scanner in = new Scanner(System.in);
        String ch = in.nextLine();
        if (ch.equals("a")){
            for (int i=0;i<pos.length;i++){
                G.writeInt(pos[i]);
                G.writeInt(neg[i]);
            }
        }
        else if (ch.equals("b")){
            for (int po : pos) {
                G.writeInt(po);
            }
            for (int i=0;i<pos.length;i++){
                G.writeInt(neg[i]);
            }
        }
        else{
            int c = 0;
            boolean check=false;
            for (int i=0;i< pos.length;i++){
                if (c%2==0){
                    check = !(check);
                }
                if (check){
                    G.writeInt(pos[i]);
                    c++;
                }
                else{
                    G.writeInt(neg[i]);
                    c++;
                }
            }
        }
    }
}
