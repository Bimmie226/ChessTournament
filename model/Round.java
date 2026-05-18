package model;

public class Round {

    private int id;
    private int roundNO;
    private Tournament tournament;

    public Round() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoundNO() {
        return roundNO;
    }

    public void setRoundNO(int roundNO) {
        this.roundNO = roundNO;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}