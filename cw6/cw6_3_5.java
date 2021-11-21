class Dog{
    String name;
    String say;
    public Dog(){}
    public Dog(String name, String say){
        this.name=name;
        this.say=say;
    }

    public void print(){
        System.out.println("Dog's name is " + this.name + " and he says " + this.say);
    }
}

public class cw6_3_5 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("spot", "Ruff!");
        Dog dog2 = new Dog("scruffy", "Wurf!");
        dog1.print();
        dog2.print();
        Dog dog3;
        dog3 = dog1;
        dog3.print();
        System.out.println(dog1==dog3);
        System.out.println(dog1.equals(dog3));
    }
}
