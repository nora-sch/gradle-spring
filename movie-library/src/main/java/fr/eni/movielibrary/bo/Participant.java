package fr.eni.movielibrary.bo;

public class Participant {
    private long id;
    private String lastName;
    private String firstName;

    public Participant(){
    }
    public Participant(long id, String lastName, String firstName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Participant(String lastName, String firstName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Participant - "+id+" : [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
