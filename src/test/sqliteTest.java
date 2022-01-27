package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class sqliteTest {
    public static void main(String[] args) {
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");

            String dbFile = "C:\\Users\\PC1\\IdeaProjects\\javaSqlite\\slitManage.db";
            con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT Date, Type FROM Substrate_Receive");
            while(rs.next()) {
                String Date = rs.getString("Date");
                String Type = rs.getString("Type");

                System.out.println(Date + " " + Type);

            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(con != null) {
                try {con.close();}catch(Exception e) {}
            }
        }
    }
}
