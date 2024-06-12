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

    @Test
    public void denemeUptade() throws SQLException {



       String prSql="INSERT INTO users (firstname, lastname, username, email, password) VALUES(?,?,?,?,?)";

        Connection connection = DriverManager.getConnection(ConnectionManage.URL,ConnectionManage.USERNAME,ConnectionManage.PASSWORD);

       PreparedStatement prSt= connection.prepareStatement(prSql);

       prSt.setString(1,"DAMRA");
       prSt.setString(2,"ESRA");
        prSt.setString(3,"SELCUK");
        prSt.setString(4,"TOPRAK");
        prSt.setString(5,"TOSUNUM");


        System.out.println(prSt.executeUpdate());
        prSt.close();


    }
}
