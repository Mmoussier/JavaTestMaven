package com.morgann.json;

/**
 * Created by morga on 28/06/2018.
 */
public class Team {
    private int id;
    private String name;
    private String location;
    private String conference; // eastern, western
    private String division; // atlantic, metropolitan, central, pacific

    public Team() {

    }

    public Team(int id, String name, String location, String conference, String division) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.conference = conference;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    //public String toString() {return  name;}
    public String toString() {
        return name + " - " + " - " + conference + " - " + division;
    }
}
