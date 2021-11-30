import classes.Student;

public class CW7_2_1 {
    public static void main(String[] args) {
        Student[] students = new Student[] {new Student("a","b","c",2000,"e","g","h","i", "j"),
                new Student("aa","ba","ca",2002,"ea","ga","ha","ia", "ja")};
        for (Student i: students){
            System.out.println("a)");
            System.out.println(i.getFaculty());
            System.out.println("b)");
            if (i.getCourse().equals("i")){
                System.out.println(i.getFaculty());
            }
            System.out.println("c)");
            if (i.getBirth() > 2000){
                System.out.println(i.getSurname());
            }
            System.out.println("d)");
            System.out.println(i.getGroup());
        }
    }
}
