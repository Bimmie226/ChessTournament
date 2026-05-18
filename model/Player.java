package model;

import java.time.LocalDate;

public class Player {

    private int id;
    private String code;
    private String name;
    private LocalDate yearOfBirth;
    private String nationality;
    private int eloCoefficients;
    private String notes;

    public Player() {

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

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(LocalDate yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getEloCoefficients() {
        return eloCoefficients;
    }

    public void setEloCoefficients(int eloCoefficients) {
        this.eloCoefficients = eloCoefficients;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}