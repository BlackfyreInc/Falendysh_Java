package cw10_t7_1;

public class Encyclopedy extends Book {
    private int items;

    Encyclopedy() {}

    Encyclopedy(String title, int n, String authors, double price) {
        super(title, n, authors, price);
    }

    public Encyclopedy(String title, int n, String authors, double price, int items) {
        this(title, n, authors, price);
        setItems(items);
    }

    public void setItems(int n) {
        this.items = n;
    }

    public int getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Encyclopedy: " + getTitle() + ", " + getAuthors();
    }
}
