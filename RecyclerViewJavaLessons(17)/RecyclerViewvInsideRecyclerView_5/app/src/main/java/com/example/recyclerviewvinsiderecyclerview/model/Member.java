package com.example.recyclerviewvinsiderecyclerview.model;

import java.util.List;

public class Member {

    private String firstName;
    private String lastName;
    private List<SubMember> subMembers;


    public Member(String firstName, String lastName, List<SubMember> subMembers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subMembers = subMembers;
    }

    public Member() {

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

    public List<SubMember> getSubMembers() {
        return subMembers;
    }

    public void setSubMembers(List<SubMember> subMembers) {
        this.subMembers = subMembers;
    }
}
