package cw9_6_1;
import java.util.Arrays;
public class Bouquet {
    public Flower[] flowers;

    Bouquet(){}

    Bouquet(Flower[] flowers){
        this.flowers = flowers;
    }

    void add_flower(Flower f){
        int n = this.flowers.length;
        Flower[] tmp = Arrays.copyOf(this.flowers, n);
        this.flowers = new Flower[n+1];
        System.arraycopy(tmp, 0, flowers, 0, n);
        flowers[n] = f;
    }

    void sort_by_date(){
        Arrays.sort(this.flowers);
    }

    Flower get_by_length(float a, float b){
        for(Flower f: this.flowers){
            if(f.length >= a && f.length <= b) return f;
        }
        return new Flower();
    }

    double price(){
        double s = 0;
        for(Flower f: this.flowers){
            s += f.price;
        }
        return s;
    }

    @Override
    public String toString(){
        String s = "";
        for(Flower f: flowers){
            s += f.toString();
        }
        return s;
    }
}
