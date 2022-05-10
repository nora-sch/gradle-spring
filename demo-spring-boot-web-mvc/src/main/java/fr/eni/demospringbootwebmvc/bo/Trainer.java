package fr.eni.demospringbootwebmvc.bo;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String firstName;
    private String lastName;
    private String email;

    //1 formateur peut dispenser plusieurs cours
    private List<Course> lstCourses;
    public Trainer() {
    //initialisation de la liste des cours.
        lstCourses = new ArrayList<Course>();
    }
    public Trainer(String firstName, String lastName, String email) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public List<Course> getLstCourses() {
        return lstCourses;
    }

    public void setLstCourses(List<Course> lstCourses) {
        this.lstCourses = lstCourses;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Trainer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email +
                "]";
    }

}
