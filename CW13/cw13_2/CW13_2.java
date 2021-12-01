package cw13_2;

public class CW13_2 {

    public static void main(String[] args) {
        Communication_Salon salon = new Communication_Salon();
        salon.add_client(new Client("Ivanov","Ivan", "305128", new String[]{"89112223355"}));
        salon.add_client(new Client("Ivanov","Ivan", "305002", new String[]{"89112223356"}));
        salon.add_client(new Client("Ivanov","Ivan", "305128", new String[]{"89112223388"}));
        salon.add_client(new Client("Ivanov","Ivan", "305128", new String[]{"89112223899"}));
        salon.add_client(new Client("Ivanov","Ivan", "305128", new String[]{"89112223800"}));

        salon.toString(salon);
    }

}
