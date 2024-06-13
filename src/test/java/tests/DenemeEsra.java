package tests;

import manage.ConnectionManage;
import org.testng.Assert;
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

    @Test
    public void updateEsra() throws SQLException {

        Connection connection = DriverManager.getConnection(ConnectionManage.URL, ConnectionManage.USERNAME,ConnectionManage.PASSWORD);

        String prtQuery = "insert into languages (name,is_default) values (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(prtQuery);
        preparedStatement.setString(1,"türkisch");
        preparedStatement.setInt(2,2);

        System.out.println(preparedStatement.executeUpdate());


    }

    @Test
    public void deleteAylin() throws SQLException {

        // delete from gateways where id = 57;

        // connection

        Connection connection = DriverManager.getConnection(ConnectionManage.URL,ConnectionManage.USERNAME, ConnectionManage.PASSWORD);

        // statement query

        String deleteQuery = "delete from gateways where id = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);

        int id = 57;

        preparedStatement.setInt(1,id);

        System.out.println(preparedStatement.executeUpdate()); // Bu bize int bir veri dondurecek, etkilenen satir sayisini dondurecek

        String controlQuery = "select * from gateways where id = ? "; // Bu da bize result set dondurecek

        PreparedStatement preparedStatement1 = connection.prepareStatement(controlQuery);

        preparedStatement1.setInt(1,id);

        ResultSet resultSet = preparedStatement1.executeQuery();

        Assert.assertFalse(resultSet.next());




    }






}
