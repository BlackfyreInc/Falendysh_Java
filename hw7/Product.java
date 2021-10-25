public class Product {
    int id;
    String name;
    int upc;
    String producer;
    int price;
    int days_left;

    public Product (int a, String b, int c, String d, int e, int f){
        id = a;
        name = b;
        upc = c;
        producer = d;
        price = e;
        days_left = f;
    }

    public Product(){

    }

    public void pr(){
        System.out.printf("ID = %d, name = %s, UPC = %d, producer = %s, price = %d, days left = %d", id, name, upc, producer, price, days_left);
    }
    public void setType(){

    }

    public void getType(){

    }

    public void tostring(){

    }

}
