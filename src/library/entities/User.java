package library.entities;

import java.util.Date;
import java.util.List;

/**
 * Created by Student on 2/11/2016.
 */
public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String addressOne;
    private String addressTwo;
    private String state;
    private String city;
    private String zipCode;
    private Date birthday;
    private String email;
    private String phone;
    private String password;
    private float fees;
    private List<Rental> rentals;

    public User() {

    }

    public User(String firstName, String lastName, Date birthday , String email, String phone, String addressOne, String addressTwo, String city, String state, String zipCode, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.state = state;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.zipCode = zipCode;
        this.password = password;
    }

    public float getFees() {
        return fees;
    }

    public void setFees(float fees) {
        this.fees = fees;
    }
/*
    public List<Rental> getRentals() {
        return rentals;
    }
*/
    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
