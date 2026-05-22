package model;

import java.util.Date;

public class Tournament {
    private int id;
    private String code;
    private String name;
    private Date year;
    private Date timeHeld;
    private String location;
    private String description;

    public Tournament() {}

    public Tournament(int id, String code, String name, Date year, Date timeHeld, String location, String description) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.year = year;
        this.timeHeld = timeHeld; 
        this.location = location; 
        this.description = description; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Date getTimeHeld() {
        return timeHeld;
    }

    public void setTimeHeld(Date timeHeld) {
        this.timeHeld = timeHeld;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}