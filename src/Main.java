import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    static String databaseName = "test.db";
    static Connection c = null;

    private static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+databaseName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:test.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS table1 (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	data text NOT NULL,\n"
                + "	timestamp double\n"
                + ");";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void insert(String data, double timestamp) {
        String sql = "INSERT INTO table1(data,timestamp) VALUES(?,?)";

        try (PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setString(1, data);
            pstmt.setDouble(2, timestamp);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void selectAll(){
        String sql = "SELECT id, data, timestamp FROM table1";

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("data") + "\t" +
                        rs.getDouble("timestamp"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception{
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e){

    }
    AppGUI app =new AppGUI();
    app.setVisible(true);

    c = connect();
    createNewTable();
    insert("Erster Wert", 1232312);
    insert("test2",999);
    selectAll();
    }

}
