package tests;

import manage.ConnectionManage;
import org.testng.annotations.Test;

import java.sql.*;

public class DenemeDamra {


    @Test
    public void test02() throws SQLException {

//1. ADIM
        Connection connection = DriverManager.getConnection(ConnectionManage.URL,ConnectionManage.USERNAME,ConnectionManage.PASSWORD);



        //2.ADım
       String query="SELECT * FROM admins";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(query);


        while (resultSet.next()){

            System.out.println(resultSet.getInt("id"));

            System.out.println(resultSet.getString("username"));
        }


    }
}
