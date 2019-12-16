/**
	File name: DatabaseConnectivity2.java
	Short description:
	IST 242 Assignment:
	@author Jared Furline
	@version 1.01 ?/??/????
*/ 
package databaseconnectivity2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jfurl
 */
public class DatabaseConnectivity2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
//Class.forName("org.apache.derby.jdbc.ClientDriver");
          Connection dbConnection = DriverManager.getConnection("jdbc:sqlite:sample.sqlite3", "app", "app");      
        // test database query
        Statement stmt = dbConnection.createStatement();
        String testQuery = "SELECT * FROM CUSTOMER";
        ResultSet results;

        results = stmt.executeQuery(testQuery);
        while (results.next()) {
           System.out.println("Result: " + results.getString("NAME"));
        }

        // clean up
        results.close();
        stmt.close();
        dbConnection.close();


    }

}
