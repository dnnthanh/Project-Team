package utilitys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import repositorys.DBContext;

public class JDBCHelper {

    public static ResultSet executeQuery(String sql, Object... arg) {
        Connection con = DBContext.getConnection();;
        ResultSet rs = null;
        if (con != null) {
            try {
                PreparedStatement prst = con.prepareStatement(sql);
                for (int i = 0; i < arg.length; i++) {
                    prst.setObject(i + 1, arg[i]);
                }
                rs = prst.executeQuery();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return rs;
    }

    public static int executeUpdate(String sql, Object... arg) {
        Connection con = null;
        PreparedStatement prst = null;
        int row = 0;
        con = DBContext.getConnection();
        if (con != null) {
            try {
                prst = con.prepareStatement(sql);
                for (int i = 0; i < arg.length; i++) {
                    prst.setObject(i + 1, arg[i]);
                }
                row = prst.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return row;
    }
}
