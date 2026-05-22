package model;

import java.util.Date;

public class Player {
    private int id;
    private String code;
    private String name;
    private String nationality;
    private Date yearOfBirth;
    private int eloCoefficient;
    private String notes;

    public Player() {}

    public Player(int id, String code, String name, String nationality, Date yearOfBirth, int eloCoefficient, String notes) {
        this.id = id; 
        this.code = code;
        this.name = name; 
        this.nationality = nationality; 
        this.yearOfBirth = yearOfBirth; 
        this.eloCoefficient = eloCoefficient; 
        this.notes = notes;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Date yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getEloCoefficient() {
        return eloCoefficient;
    }

    public void setEloCoefficient(int eloCoefficient) {
        this.eloCoefficient = eloCoefficient;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}