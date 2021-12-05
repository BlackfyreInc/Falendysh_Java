package cw13_1;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class CW13_1 {

    public static void add_to_BinaryFile(String filename, Student[] students) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject(students);
        objectOutputStream.close();
    }


    public static Student[] add_student_to_Array(Student[] students, Student student){
        students = Arrays.copyOf(students, students.length + 1);
        students[students.length - 1] = student;
        return students;
    }

    public static void find_studentByFullName(String filename, String name) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        Student[] students = (Student[]) (objectInputStream.readObject());
        for(Student s: students){
            if(Objects.equals(s.FullName, name)){
                System.out.println("Printing the result and creating binary file of needed student in src: " + s);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/cw13_1/" + name + ".bin"));
                objectOutputStream.writeObject(s);
                objectOutputStream.close();
                break;
            }
        }
        objectInputStream.close();
    }

    public static void find_best_student(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        Student[] students = (Student[]) (objectInputStream.readObject());
        Student best = students[0];
        for(Student s: students){
            if(s.average_mark() > best.average_mark()){
                best = s;
            }
        }
        System.out.println("Best student is " + best + " and his rating mark equals " + best.average_mark());
        objectInputStream.close();
    }

    public static void find_worst_student(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        Student[] students = (Student[]) (objectInputStream.readObject());
        Student worst = students[0];
        for(Student s: students){
            if(s.average_mark() < worst.average_mark()){
                worst = s;
            }
        }
        System.out.println("Worst student is " + worst + " and his rating mark equals " + worst.average_mark());
        objectInputStream.close();
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student[] students = new Student[]{new Student("First", "228", 4, new int[]{5, 3, 5, 4, 4, 3}),
                new Student("Second", "322", 4, new int[]{3, 5, 3, 4, 5, 5}),
                new Student("Third", "12345", 5, new int[]{5, 2, 4, 4, 4, 4})};

        add_to_BinaryFile("src/cw13_1/students.bin", students);


        students = add_student_to_Array(students, new Student("Fourth", "666", 4, new int[]{4, 2, 5, 5, 5, 3}));
        students = add_student_to_Array(students, new Student("Fifth", "4.1", 6, new int[]{5, 5, 5, 5, 5, 5}));



        add_to_BinaryFile("src/cw13_1/students.bin", students);

        find_studentByFullName("src/cw13_1/students.bin", "Fifth");

        find_best_student("src/cw13_1/students.bin");

        find_worst_student("src/cw13_1/students.bin");
    }
}
