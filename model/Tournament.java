package model;

import java.time.LocalDate;

public class Tournament {

    private int id;
    private String code;
    private String name;
    private LocalDate year;
    private LocalDate timeHeld;
    private String location;
    private String description;

    public Tournament() {

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

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public LocalDate getTimeHeld() {
        return timeHeld;
    }

    public void setTimeHeld(LocalDate timeHeld) {
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