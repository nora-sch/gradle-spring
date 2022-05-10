package fr.eni.demospringbootwebmvc.bo;

public class Trainer {
    private String firstName;
    private String lastName;
    private String email;
    public Trainer() {
    }
    public Trainer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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
