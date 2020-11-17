package HW2;

import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) {
        try {
            connect();
            createTable("users");
            addUser("Roman", 29);
            addUser("Artem", 28);
            System.out.println(selectRecord(2));
            System.out.println(selectRecord(1));
            deleteRow(2);
            deleteTable("users");
            disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    private static void disconnect() throws SQLException {
        connection.close();
    }

    private static void createTable(String tableName) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS "+ tableName +" (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(255), age INT);";
        stmt.execute(query);
    }

    private static void addUser(String name, int age) throws SQLException {
        String query = "INSERT INTO users (name, age) VALUES (?, ?);";
        pstmt = connection.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.setInt(2, age);
        pstmt.addBatch();
        pstmt.executeBatch();
    }

    private static String selectRecord(int n) {
        String query = "SELECT * FROM users WHERE id=" + n + ";";
        try {
            ResultSet rs = stmt.executeQuery(query);
            return rs.getInt(1) + " " + rs.getString("name")
                    + " " + rs.getInt(3);
        } catch (SQLException e) {
            return "Row " + n + " is not exists";
        }
    }

    private static void deleteRow(int n) throws SQLException {
        String query = "DELETE FROM users WHERE id=" + n + ";";
        stmt.executeUpdate(query);
    }

    private static void deleteTable(String tableName) throws SQLException {
        String query = "DROP TABLE IF EXISTS " + tableName;
        stmt.execute(query);
    }
}
