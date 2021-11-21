package cw10_SE;

class Zero_Exception extends ArithmeticException {
    private String detail;

    Zero_Exception(String message) {
        detail = message;
    }

    @Override
    public String toString() {
        return detail;
    }
}


class Discriminant_Exception extends ArithmeticException {
    private double a, b, c, d;

    Discriminant_Exception(String message, double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public String toString() {
        return "Discriminant is " + d + " - invalid";
    }
}