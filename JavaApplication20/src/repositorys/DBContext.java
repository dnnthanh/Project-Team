package repositorys;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

    public static String user = "thanh1908";
    public static String pass = "thanh1908SQLSERVER";
    public static String url = "jdbc:sqlserver://localhost:1433;databaseName=Application_Nhom6;";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            boolean usingssl = true;

            if (usingssl) {
                url += "encrypt=true;trustServerCertificate=true;";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, pass);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
    
    public static void main(String[] args) {
        System.out.println(DBContext.getConnection());
    }
}
