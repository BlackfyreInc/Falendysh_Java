import java.io.*;

public class cw12_bin_1 {
    public static void main(String[] args) throws IOException {
        double[] nums = {4.5, 6.5, 7.5};
        DataOutputStream out = new DataOutputStream(new FileOutputStream("src/filein.txt"));
        for(double d: nums){
            out.writeDouble(d);
        }

        DataInputStream in = new DataInputStream(new FileInputStream("src/filein.txt"));
        double sum = 0.0;
        while(in.available() > 0) {
            sum += in.readDouble();
            System.out.println(sum);
        }

        DataOutputStream out1 = new DataOutputStream(new FileOutputStream("src/fileout.txt"));
        out1.writeDouble(sum);
        System.out.println(sum);
    }
}
