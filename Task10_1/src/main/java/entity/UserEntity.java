package entity;

import bean.User;

/**
 * Created by Tetiana_Matiunina on 06.11.2015.
 */
public class UserEntity {

    private static int count = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String loginName;
    private String email;
    private String password;
    private String female;


    public UserEntity(User user) {
        ++count;
        id = count;
        firstName = user.getFirstName();
        lastName = user.getSecondName();
        loginName = user.getLoginName();
        email = user.getEmail();
        password = user.getPassword();
        female = user.getFemale();
    }

    public int getId() {
        return id;
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }
}
