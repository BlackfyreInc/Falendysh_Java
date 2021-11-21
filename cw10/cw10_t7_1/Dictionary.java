package cw10_t7_1;

class Dictionary extends Book {
    private String lang1;
    private String lang2;
    private int items;

    public Dictionary() {}

    public Dictionary(String title, int n, String authors, double price) {
        super(title, n, authors, price);
    }

    public Dictionary(String title, int n, String authors, double price, String l1, String l2, int items) {
        this(title, n, authors, price);
        setLang1(l1);
        setLang2(l2);
        setItems(items);
    }

    public void setLang1(String l1) {
        this.lang1 = l1;
    }

    public void setLang2(String l2) {
        this.lang2 = l2;
    }

    public void setItems(int n) {
        this.items = n;
    }

    public String getLang1() {
        return lang1;
    }

    public String getLang2() {
        return lang2;
    }

    public int getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Dictionary: " + lang1 + " -> " + lang2 + ": " + getTitle() + ", " + getAuthors();
    }
}