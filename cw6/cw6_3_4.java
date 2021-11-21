class OverloadMess{
    public OverloadMess(){
        System.out.println("Test message");
    }
    public OverloadMess(String str){
        this();
        System.out.println(str);
    }
}

public class cw6_3_4 {
    public static void main(String[] args) {
        OverloadMess c = new OverloadMess("My message");
    }
}
