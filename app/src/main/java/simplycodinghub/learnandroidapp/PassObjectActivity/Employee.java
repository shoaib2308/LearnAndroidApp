package simplycodinghub.learnandroidapp.PassObjectActivity;

import java.io.Serializable;

public class Employee implements Serializable {

    String name, gender, qualification;
    String[] hobbies;

    public Employee(String name, String gender, String qualification, String[] hobbies) {
        this.name = name;
        this.gender = gender;
        this.qualification = qualification;
        this.hobbies = hobbies;
    }
}
