package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class insertTest {

    public static String id;
    public static String getNumber() {
        id = "Number of Rows";
        return scanner();
    }
    public static String getDate() {
        id = "Date";
        return scanner();
    }
    public static String getType() {
        id = "Type";
        return scanner();
    }
    public static String getThick() {
        id = "Thick";
        return scanner();
    }
    public static String getWidth() {
        id = "Width";
        return scanner();
    }
    public static String getLength() {
        id = "Length";
        return scanner();
    }
    public static String getQuantity() {
        id = "Quantity";
        return scanner();
    }

    public static String scanner() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter " + id + " : " );
        String str= sc.nextLine();
        return str;
    }

    public static void main(String[] args) {

        int no = Integer.parseInt(getNumber());
        int sum = 0;

        for (int i = 0; i < no; i++) {

            Connection con = null;
            PreparedStatement pstmt = null;

            String driver = "org.sqlite.JDBC";
            String dbFile = "C:\\Users\\PC1\\IdeaProjects\\javaSqlite\\slitManage.db";

            String SQL = "INSERT INTO Substrate_Receive(Date,Type,Thick,Width,Length,Quantity) VALUES (?,?,?,?,?,?)";

            String s1 = getDate();
            String s2 = getType();
            String s3 = getThick();
            String s4 = getWidth();
            String s5 = getLength();
            String s6 = getQuantity();

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

