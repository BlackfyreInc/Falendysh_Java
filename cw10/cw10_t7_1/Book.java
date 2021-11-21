package cw10_t7_1;

abstract class Book implements Edition {
    private int printings;
    private String title;
    private String authors;
    private double price;

    Book() {}

    Book(String title, int n, String authors, double price) {
        this.title = title;
        setPrintings(n);
        this.authors = authors;
        this.price = price;
    }

    public int getPrintings() {
        return printings;
    }

    public void setPrintings(int n) {
        printings = n;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String s) {
        this.title = s;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    @Override
    public String toString() {
        return "Book: " + getTitle() + ", " + getAuthors();
    }
}
