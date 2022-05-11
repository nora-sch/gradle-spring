package fr.eni.demospringbootwebmvc.bo;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class Trainer {
    @NotBlank
    @Size(min = 4, max=250)
    private String firstName;
    @NotBlank
    @Size(min = 4, max=250, message = "Le nom doit avoir au moins 4 caractères")
    private String lastName;

    @NotBlank
    @Email
    @Pattern(regexp="^[\\w-\\.]+@campus-eni.fr$")
    private String email;

    //1 formateur peut dispenser plusieurs cours
    @NotEmpty(message="lstCourses est vide")
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
