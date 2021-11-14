package cw9_6_1;
public class cw9_6_1 {
    public static void main(String[] args){
        Flower[] flowers = {new Rose(10, 1, 10, "09"),
                new Rose(9, 2, 15, "30"),
                new Daisy(15, 1, 7, "28"),
                new Lily(20,  3, 19, "15")};

        Bouquet bouquet = new Bouquet(flowers);
        bouquet.sort_by_date();
        System.out.println("Sorted bouquet by date:\n" + bouquet + "\n");

        System.out.println("Flower with length between 11 and 17:" + bouquet.get_by_length(11, 17));
    }
}
