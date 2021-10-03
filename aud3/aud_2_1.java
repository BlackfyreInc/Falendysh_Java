public class aud_2_1 {
    public static void main(String[] args){
        int a = 0x15;
        int b = 0x17;
        System.out.println(a);
        System.out.println(Integer.toBinaryString(a|b));
        System.out.println(Integer.toBinaryString(a^b));
        System.out.println(Integer.toBinaryString(a&b));
        System.out.println(Integer.toBinaryString(a>>>1));
    }

}
