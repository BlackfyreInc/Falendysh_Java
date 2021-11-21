package cw9_6_1;
class Rose extends Flower{
    public Rose() {
        super();
    }

    public Rose(float p, int c, float U, String d) {
        super(p, c, U, d);
    }

    @Override
    public String toString() {
        return "\nRose  " + "color: " + super.color + ", price:" + super.price + ", length: " + super.length + ", date: " + super.date;
    }
}

class Daisy extends Flower{
    public Daisy() {
        super();
    }

    public Daisy(float p, int c, float U, String d) {
        super(p, c, U, d);
    }

    @Override
    public String toString() {
        return "\nDaisy  " + "color: " + super.color + ", price:" + super.price + ", length: " + super.length + ", date: " + super.date;
    }
}

class Lily extends Flower{
    public Lily() {
        super();
    }

    public Lily(float p, int c, float U, String d) {
        super(p, c, U, d);
    }

    @Override
    public String toString() {
        return "\nLily  " + "color: " + super.color + ", price:" + super.price + ", length: " + super.length + ", date: " + super.date;
    }
}