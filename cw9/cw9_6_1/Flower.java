package cw9_6_1;
public class Flower implements Comparable<Flower> {

    public float price;
    public int color;
    public float length;
    public String date;

    public Flower() {
    }

    public Flower(float p, int c, float l, String s) {
        this.price = p;
        this.color = c;
        this.length = l;
        this.date = s;
    }

    public boolean equals(Flower obj) {
        return this.price == obj.price & this.color == obj.color && this.length == obj.length;
    }


    @Override
    public int compareTo(Flower o) {
        return this.date.compareTo(o.date);
    }
}