package fr.eni.movielibrary.bo;

public class Member {
    private long id;
    private String lastName;
    private String firstName;
    private String login;
    private String password;
    private boolean isAdmin;

    public Member(){
    }
    public Member(long id, String lastName, String firstName, String login, String password, boolean isAdmin ){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    public Member(String lastName, String firstName, String login, String password, boolean isAdmin ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "Member - "+id+" : [firstName=" + firstName + ", lastName=" + lastName + ", \nlogin=" + login + ", \n"+ (isAdmin?"ADMIN":"MEMBER") + "]";
    }
}
