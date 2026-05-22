package dao; 

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Staff;

public class StaffDAO extends DAO {

    public StaffDAO() {
        super();
    }

    public boolean checkLogin(Staff staff) {

        boolean result = false;

        String sql =
            "SELECT * FROM staff " +
            "WHERE username=? AND password=?";

        try {

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, staff.getUsername());
            ps.setString(2, staff.getPassword());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                staff.setId(
                        rs.getInt("id")
                );

                staff.setFirstName(
                        rs.getString("firstName")
                );

                staff.setLastName(
                        rs.getString("lastName")
                );

                result = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}