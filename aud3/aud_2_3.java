public class aud_2_3 {
    public static String chartobin(char a){
        return Integer.toBinaryString(a);
    }
    public static void main(String[] args) {
        char a = 'a';
        System.out.println(chartobin(a));
    }
}
