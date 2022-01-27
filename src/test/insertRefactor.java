package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

class Value{
    public static String id = "";
    public static String scanner(String id) {
        Value.id = id;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter " + Value.id + " : " );
        String str= sc.nextLine();
        return str;
    }
}

public class insertRefactor {

    public static void main(String[] args) {

        int no = Integer.parseInt(Value.scanner("Number of Rows"));
        int sum = 0;

        for (int i = 0; i < no; i++) {

            Connection con = null;
            PreparedStatement pstmt = null;

            String driver = "org.sqlite.JDBC";
            String dbFile = "C:\\Users\\PC1\\IdeaProjects\\javaSqlite\\slitManage.db";

            String SQL = "INSERT INTO Substrate_Receive(Date,Type,Thick,Width,Length,Quantity) VALUES (?,?,?,?,?,?)";

            String s1 = Value.scanner("YYMMDD");
            String s2 = Value.scanner("TYPE");
            String s3 = Value.scanner("THICKNESS");
            String s4 = Value.scanner("WIDTH");
            String s5 = Value.scanner("LENGTH");
            String s6 = Value.scanner("QUANTITY");

            try {
                Class.forName(driver);
                con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

                pstmt = con.prepareStatement(SQL);

                pstmt.setString(1, s1);
                pstmt.setString(2, s2);
                pstmt.setString(3, s3);
                pstmt.setString(4, s4);
                pstmt.setString(5, s5);
                pstmt.setString(6, s6);

                int r = pstmt.executeUpdate();

                System.out.println("변경된 row : " + r);


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Exception e) {
                    }
                }
            }
        }


    }
}

