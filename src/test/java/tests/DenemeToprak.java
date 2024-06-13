package tests;

import manage.ConnectionManage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class DenemeToprak {

    @Test
    public void toprakstatement() throws SQLException {

        Connection connection = DriverManager.getConnection(ConnectionManage.URL,ConnectionManage.USERNAME,ConnectionManage.PASSWORD);

        String query = "SELECT * FROM admins";

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){

            System.out.print(resultSet.getInt("id"));
            System.out.println(" :"+resultSet.getString("email"));

        }

    }

    @Test
    public void toprakupdate() throws SQLException {

        String sql = "INSERT INTO admins (name,email,username,password) VALUES (?,?,?,?)";

        Connection connection = DriverManager.getConnection(ConnectionManage.URL,ConnectionManage.USERNAME,ConnectionManage.PASSWORD);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,"Toprak");
        preparedStatement.setString(2,"toprak1@gmail.com");
        preparedStatement.setString(3,"Toprak1");
        preparedStatement.setString(4,"toprak");

        System.out.println(preparedStatement.executeUpdate());
        preparedStatement.close();


    }

    @Test
    public void toprakdelete() throws SQLException {

        Connection connection = DriverManager.getConnection(ConnectionManage.URL,ConnectionManage.USERNAME,ConnectionManage.PASSWORD);

        int idDelete=56;

        String queryDelete = "delete from gateways where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);

        preparedStatement.setInt(1,idDelete);

        System.out.println(preparedStatement.executeUpdate());


        String queryControl = "select * from gateways where id = ?";

        PreparedStatement preparedStatement1 = connection.prepareStatement(queryControl);

        preparedStatement1.setInt(1,idDelete);

        ResultSet resultSet = preparedStatement1.executeQuery();

        Assert.assertFalse(resultSet.next());

        connection.close();


    }






}
