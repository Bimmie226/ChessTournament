package model;

import java.util.ArrayList;
import java.util.Date;

public class Match {
    private int id;
    private int tableNO;
    private Date dateTime;
    private String location;
    private Round round;
    private ArrayList<Player> players; 

    public Match() {}

    public Match(int id, int tableNO, Date dateTime, String location, Round round) {
        this.id = id;
        this.tableNO = tableNO;
        this.dateTime = dateTime; 
        this.location = location; 
        this.round = round;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableNO() {
        return tableNO;
    }

    public void setTableNO(int tableNO) {
        this.tableNO = tableNO;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}