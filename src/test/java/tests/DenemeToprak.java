package tests;

import manage.ConnectionManage;
import org.testng.annotations.Test;

import java.sql.*;

public class DenemeToprak {

    @Test
    public void topraktest() throws SQLException {

        Connection connection = DriverManager.getConnection(ConnectionManage.URL,ConnectionManage.USERNAME,ConnectionManage.PASSWORD);

        String query = "SELECT * FROM admins";

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){

            System.out.print(resultSet.getInt("id"));
            System.out.println(" :"+resultSet.getString("email"));

        }



    }
}
