package org.ilroberts.entities;

import javax.persistence.*;

@Entity
@SuppressWarnings("unused")
@Table(name = "physician_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @ManyToOne()
    private User user;

    private String Line1;
    private String Line2;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getLine1() {
        return Line1;
    }

    public void setLine1(String line1) {
        Line1 = line1;
    }

    public String getLine2() {
        return Line2;
    }

    public void setLine2(String line2) {
        Line2 = line2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    private String City;
    private String State;
    private String Zip;

}
