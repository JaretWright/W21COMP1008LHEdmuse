package models;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String firstname, lastName, address;
    private LocalDate birthday;

    public Person(String firstname, String lastName, String address, LocalDate birthday) {
        setFirstName(firstname);
        setLastName(lastName);
        setAddress(address);
        setBirthday(birthday);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        firstname = firstname.trim();
        if (firstname.length()>2)
            this.firstname = firstname;
        else
            throw new IllegalArgumentException("first name requires at least 2 characters");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * This method will return the amount of complete years since the birthday to the current date
     */
    public int getAge()
    {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}
