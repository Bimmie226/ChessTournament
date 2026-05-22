package dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.MatchResult;

public class MatchResultDAO extends DAO {

    public MatchResultDAO() {
        super();
    }

    public boolean saveMatchResult(ArrayList<MatchResult> listResult) { 
        String sql = "INSERT INTO matchresult (result, eloChange, playerID, matchID, staffID) VALUES(?,?,?,?,?)";

        try { 
            PreparedStatement ps = con.prepareStatement(sql);

            for (MatchResult mr : listResult) {
                ps.setString(1, mr.getResult());
                ps.setFloat(2, mr.getEloChange());
                ps.setInt(3, mr.getPlayer().getId()); 
                ps.setInt(4, mr.getMatch().getId());
                ps.setInt(5, mr.getStaff().getId());

                ps.executeUpdate();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}