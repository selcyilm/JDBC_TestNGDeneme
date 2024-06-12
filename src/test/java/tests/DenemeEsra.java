package tests;

import manage.ConnectionManage;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.sql.*;

public class DenemeEsra {

    @Test
    public void testEsra () throws SQLException {

        // 1. adim connectioni kuruyoruz

        Connection connection = DriverManager.getConnection(ConnectionManage.URL,ConnectionManage.USERNAME,ConnectionManage.PASSWORD);

        // 2. adim statement
        String query = "SELECT * FROM admins";

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()){

            System.out.println(resultSet.getString("username"));

        }


    }



}
