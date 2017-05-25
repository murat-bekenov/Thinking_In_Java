package sg.edu.ntu;

import java.sql.*;

public class JdbcSelectTest {
    public static void main(String[] args) {
        // Step 1: Allocate a database 'Connection' object
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookshop?useSSL=false", "murat", "muratbek");
            // MySQL: "jdbc:mysql://localhost:3306/ebookshop?useSSL=false", "murat", "muratbek"


            // Step 2: Allocate a 'Statement' object in the Connection
            Statement stmt = conn.createStatement();

            // Step 3: Execute a SQL SELECT query, the query result
            // is returned in a 'ResultSet' object.
            String strSelect = "select title, price, qty from books";
            System.out.println("The SQL query is: " + strSelect); // Echo For debugging
            System.out.println();

            ResultSet rset = stmt.executeQuery(strSelect);


            // Step 4: Process the ResultSet by scrolling the cursor forward via next().
            // For each row, retrieve the contents of the cells with getXxx(columnName).
            System.out.println("The records selected are:");
            int rowCount = 0;
            while (rset.next()) { // Move the cursor to the next row, return false if no more row
                String title = rset.getString("title");
                double price = rset.getDouble("price");
                int qty = rset.getInt("qty");
                System.out.println(title + ", " + price + ", " + qty);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
