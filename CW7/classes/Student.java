package classes;

public class Student {
    String surname, name, third_name,  address, phone_num, faculty, course, group;
    int birth;
    public Student(String s, String n, String t_n, int b, String a, String p_n, String f, String c, String g){
        this.surname=s;
        this.name=n;
        this.third_name=t_n;
        this.birth=b;
        this.address=a;
        this.phone_num=p_n;
        this.faculty=f;
        this.course=c;
        this.group=g;
    }

    public Student() {}

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setThird_name(String third_name){
        this.third_name = third_name;
    }

    public void setBirth(int birth){
        this.birth = birth;
    }

    public void setFaculty(String faculty){
        this.faculty = faculty;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPhone_num(String phone_num){
        this.phone_num = phone_num;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public void setGroup(String group){
        this.group = group;
    }

    public String getSurname(){
        return surname;
    }

    public String getName(){
        return name;
    }

    public String getThird_name(){
        return third_name;
    }

    public int getBirth(){
        return birth;
    }

    public String getAddress(){
        return address;
    }

    public String getPhone_num(){
        return phone_num;
    }

    public String getFaculty(){
        return faculty;
    }

    public String getCourse(){
        return course;
    }

    public String getGroup(){
        return group;
    }

    @Override
    public String toString(){
        return surname + '\t' + name + '\t' + faculty;
    }
}
