class Doggo{
    String name;
    String say;
    public Doggo(){}
    public Doggo(String name, String say){
        this.name=name;
        this.say=say;
    }

    public String bark(double m){
        return "Dog barks " + m;
    }

    public String bark(int m){
        return "Dog barks " + m;
    }

    public String bark(String m){
        return "Dog barks " + m;
    }

    public String bark(char m){
        return "Dog barks " + m;
    }

    public void print(){
        System.out.println("Dog's name is " + this.name + " and he says " + this.say);
    }
}

public class cw6_3_6 {
    public static void main(String[] args) {
        Doggo doggo = new Doggo("spot", "nice");
        System.out.println(doggo.bark(1));
        System.out.println(doggo.bark('G'));
        System.out.println(doggo.bark(5.0));
        System.out.println(doggo.bark("Bark"));
    }
}
