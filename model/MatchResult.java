package model;

public class MatchResult {
    private int id;
    private String result;
    private float eloChange;
    private Player player;
    private Match match;
    private Staff staff;

    public MatchResult() {}

    public MatchResult(int id, String result, float eloChange, Player player, Match match, Staff staff) {
        this.id = id;
        this.result = result; 
        this.eloChange = eloChange; 
        this.player = player; 
        this.match = match; 
        this.staff = staff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public float getEloChange() {
        return eloChange;
    }

    public void setEloChange(float eloChange) {
        this.eloChange = eloChange;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}