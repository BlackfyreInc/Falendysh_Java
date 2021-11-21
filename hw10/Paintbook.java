public class Paintbook extends Notebook {
    private String type_of_paper;

    Paintbook() {}

    Paintbook(String type, int n, double price) {
        super(type, n, price);
    }

    public Paintbook(String type, int n, double price, String type_of_paper) {
        this(type, n, price);
        setItems(type_of_paper);
    }

    public void setItems(String n) {
        this.type_of_paper = n;
    }

    public String getType_of_paper() {
        return type_of_paper;
    }

    @Override
    public String toString() {
        return "Paintbook: " + getType() + ", " + getLength() + ", " + getPrice() + ", " + getType_of_paper() + ".";
    }
}