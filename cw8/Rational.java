package cw8;
public class Rational {
    int n;
    int m;

    private static int gcd(int n, int d) {
        return (d == 0 ? n : gcd(d, n % d));
    }

    public Rational(int a,int b){
        n = a;
        m = b;
        int divisor = gcd(n, m);
        this.n = n / divisor;
        this.m = m / divisor;
    }

    public Rational(){}

    public void get_ratio(){
        System.out.println(n+"/"+m);
    }
}
