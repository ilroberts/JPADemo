package org.ilroberts.entities;

import org.hibernate.annotations.Cascade;
import org.ilroberts.enums.Gender;
import org.ilroberts.enums.UserTypes;

import javax.persistence.*;
import java.util.List;

@Entity
@SuppressWarnings("unused")
@Table(name = "physician_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private Gender gender;

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @OneToMany(cascade = CascadeType.ALL)
    List<Address> addressList;

    String firstName;

    protected User() {
        // required by JPA spec
    }

    public User(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = UserTypes.UNDEFINED;
        this.gender = gender;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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

    public UserTypes getUserType() {
        return userType;
    }

    public void setUserType(UserTypes userType) {
        this.userType = userType;
    }

    private String lastName;

    private UserTypes userType;
}
