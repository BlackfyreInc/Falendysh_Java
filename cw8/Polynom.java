package cw8;

public class Polynom {
    Rational[] coef;
    public Polynom(Rational[] a){
        coef = a;
    }
    public Polynom(){

    }
    public void get_poly(){
        for(int i = 0; i < coef.length; i++){

            System.out.print(coef[i].n+"/"+coef[i].m+" * x^("+(i+1) + ") ");
        }

    }
}
