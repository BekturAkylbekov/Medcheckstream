package Models;

import java.util.Comparator;

public class Patient {
    private long id;
    private  String firstName,lastName;
    private int age;
    Gender gender;

    public Patient(long id, String firstName, String lastName, int age, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Patient() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
public static Comparator<Patient> sortByageAsk=new Comparator<Patient>() {
    @Override
    public int compare(Patient patient1, Patient patient2) {
        return patient1.getAge()-patient2.getAge();
    }
};public static Comparator<Patient> sortByagedDesk=new Comparator<Patient>() {
    @Override
    public int compare(Patient patient1, Patient patient2) {
        return patient2.getAge()-patient1.getAge();
    }
};
    @Override
    public String toString() {
        return "\nPatient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
