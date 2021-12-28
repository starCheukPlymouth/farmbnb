package com.starcomp.farmbnb.model;

public class Profile {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String password;
    private final String userClass;

    public Profile(String firstName, String lastName, String address, String phoneNumber, String password, String userClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userClass = userClass;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() { return firstName + " " + lastName; }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getUserClass() {
        return userClass;
    }
}
