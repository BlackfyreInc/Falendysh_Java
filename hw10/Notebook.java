abstract class Notebook implements Paper {
    private int length;
    private String type;
    private double price;

    Notebook() {}

    Notebook(String type, int n, double price) {
        this.type = type;
        setLength(n);
        this.price = price;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int n) {
        length = n;
    }

    public String getType() {
        return type;
    }

    public void setType(String s) {
        this.type = s;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    @Override
    public String toString() {
        return "Notebook: " + getType() + ", " + getLength() + ", " + getPrice() + ".";
    }
}

