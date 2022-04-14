package com.revature.videoGameLand.models;

import com.revature.videoGameLand.services.ShoppingCartService;

public class Customer {
    private int id;
    private boolean manager;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private int houseNumber;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;
    public Customer() {
    }

    public Customer(int id, boolean manager, String firstName, String lastName, String email, String userName, String password, int houseNumber, String streetName, String city, String state, String zipCode) {
        this.id = id;
        this.manager = manager;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHouseNumber() {return houseNumber; }

    public void setHouseNumber(int houseNumber) { this.houseNumber = houseNumber; }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    @Override
    public String toString() {
        return "\n\nID: " + id +
                "\nUsername : " + userName +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nStreet Address: " + houseNumber +
                " " + streetName +
                "\nCity: " + city +
                "\nState: " + state +
                "\nZip Code: " + zipCode;
    }
}