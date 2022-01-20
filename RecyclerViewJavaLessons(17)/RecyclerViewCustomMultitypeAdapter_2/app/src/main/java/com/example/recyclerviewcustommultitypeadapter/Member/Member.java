package com.example.recyclerviewcustommultitypeadapter.Member;

public class Member {

    private String firstName;
    private String lastName;
    private boolean available;

    public Member(String firstName, String lastName, Boolean available) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.available = available;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
