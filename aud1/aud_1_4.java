public class aud_1_4 {
    public static void main(String[] args) {
        NewClass nw1 = new NewClass();
        NewClass nw2 = new NewClass();
        NewClass nw3 = new NewClass();
        System.out.println(nw1.number);
        nw2.number = 4;
        System.out.println(nw3.number);
        System.out.println(NewClass.number);
        System.out.println(nw1.number == nw2.number);
        System.out.println(nw2.number == nw3.number);
    }
}

class NewClass {
    static int number = 3;
}