package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Match;
import model.Player;
import model.Round;

public class MatchDAO extends DAO {
    public MatchDAO() {
        super();
    }

    public ArrayList<Match> getMatchesByRound(Round r) {

        ArrayList<Match> result =
                new ArrayList<>();

        String sql =
            "SELECT " +
            "m.id AS mid, " +
            "m.tableNO, " +
            "m.dateTime, " +
            "m.location, " +
            "p.id AS pid, " +
            "p.name AS pname " +
            "FROM `match` m " +
            "LEFT JOIN matchresult mr " +
            "ON m.id = mr.matchID " +
            "LEFT JOIN player p " +
            "ON mr.playerID = p.id " +
            "WHERE m.roundID=? " +
            "ORDER BY m.id";

        try {

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, r.getId());

            ResultSet rs = ps.executeQuery();

            Match currentMatch = null;

            int currentMatchID = -1;

            while (rs.next()) {

                int matchID =
                        rs.getInt("mid");

                // Match mới
                if (matchID != currentMatchID) {

                    currentMatch = new Match();

                    currentMatch.setId(matchID);

                    currentMatch.setTableNO(
                            rs.getInt("tableNO")
                    );

                    currentMatch.setDateTime(
                            rs.getDate("dateTime")
                    );

                    currentMatch.setLocation(
                            rs.getString("location")
                    );

                    currentMatch.setRound(r);

                    currentMatch.setPlayers(
                            new ArrayList<>()
                    );

                    result.add(currentMatch);

                    currentMatchID = matchID;
                }

                // Player
                Player p = new Player();

                p.setId(rs.getInt("pid"));

                p.setName(
                        rs.getString("pname")
                );

                currentMatch
                        .getPlayers()
                        .add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
