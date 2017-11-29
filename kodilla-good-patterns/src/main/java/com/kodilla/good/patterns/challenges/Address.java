package com.kodilla.good.patterns.challenges;

public class Address {

    private String fullName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zipCode;
    private String state;
    private String country;
    private String phone;

    public Address(final String fullName, final String addressLine1,
                   final String addressLine2, final String city, final String zipCode,
                   final String state, final String country, final String phone) {
        this.fullName = fullName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "fullName='" + fullName + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
