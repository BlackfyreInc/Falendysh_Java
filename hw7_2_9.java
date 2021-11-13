import java.util.Scanner;

public class hw7_2_9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of products: ");
        int n = in.nextInt();
        in.nextLine();
        Product[] products_arr = new Product[n];
        for (int i=0;i<n;i++){
            System.out.println("Enter product's id: ");
            int id = in.nextInt();
            in.nextLine(); //это для корректной роботы nextLine, по-другому исправить не вышло
            System.out.println("Enter product's name: ");
            String name = in.nextLine();
            System.out.println("Enter product's UPC: ");
            int upc = in.nextInt();
            in.nextLine();
            System.out.println("Enter product's producer: ");
            String producer = in.nextLine();
            System.out.println("Enter product's price: ");
            int price = in.nextInt();
            System.out.println("Enter products's freshness date: ");
            int days_left = in.nextInt();
            Product t = new Product(id, name, upc, producer, price, days_left);
            products_arr[i] = t;
        }

        System.out.println("Enter your product's name: ");
        in.nextLine();
        String given_name = in.nextLine();
        for(int i = 0; i < n;i++){
            if(products_arr[i].name.equals(given_name)){
                products_arr[i].pr();
            }
        }

        System.out.println("Enter your product's price: ");
        int given_price = in.nextInt();
        for(int i = 0; i < n;i++){
            if((products_arr[i].name.equals(given_name)) & (products_arr[i].price < given_price)){
                products_arr[i].pr();
            }
        }

        System.out.println("Enter your product's freshness date: ");
        int given_days_left = in.nextInt();
        for(int i = 0; i < n;i++){
            if(products_arr[i].days_left > given_days_left){
                products_arr[i].pr();
            }
        }
    }
}
