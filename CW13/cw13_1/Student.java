package cw13_1;

import java.util.Arrays;
import java.io.Serializable;

public class Student implements Serializable{

    public String RecordBookNumber;
    public String FullName;
    public int PassedSubjects;
    public int[] marksArray;

    public Student() {}

    public Student(String FN, String RBN, int PS, int[] mA) {
        this.FullName = FN;
        this.RecordBookNumber = RBN;
        this.PassedSubjects = PS;
        this.marksArray = mA;
    }

    public String getRecordBookNumber(){
        return RecordBookNumber;
    }

    public String getFullName(){
        return FullName;
    }

    public int getPassedSubjects(){
        return PassedSubjects;
    }

    public void setRecordBookNumber(String s){
        this.RecordBookNumber = s;
    }

    public void setFullName(String s){
        this.FullName = s;
    }

    public void setPassedSubjects(int i){
        this.PassedSubjects = i;
    }

    public double average_mark(){
        double average = 0;
        for(int m: marksArray){
            average += m;
        }
        return average / marksArray.length;
    }

    @Override
    public String toString(){
        return this.FullName + ", " + this.RecordBookNumber + ", " + this.PassedSubjects + ", " + Arrays.toString(this.marksArray);
    }

}