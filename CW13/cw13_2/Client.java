package cw13_2;

import java.util.Arrays;

public class Client {
    public String name;
    public String surname;
    public String IdentificationCode;
    public String[] PhoneNumbersArray;

    Client(String name, String surname, String IC, String[] PNA){
        this.name = name;
        this.surname = surname;
        this.IdentificationCode = IC;
        Arrays.sort(PNA);
        this.PhoneNumbersArray = PNA;
    }

    Client(){}

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getIdentificationCode(){
        return IdentificationCode;
    }

    public void setName(String s){
        this.name = s;
    }

    public void setSurname(String s){
        this.surname = s;
    }

    public void setIdentificationCode(String s){
        this.IdentificationCode = s;
    }

    @Override
    public String toString(){
        return this.name + " " + this.surname + " " + this.IdentificationCode + " " + Arrays.toString(this.PhoneNumbersArray);
    }
}
