package tests;

import manage.ConnectionManage;
import org.testng.Assert;
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

       prSt.setString(1,"DAMRAA");
       prSt.setString(2,"ESRAA");
        prSt.setString(3,"SELCUKK");
        prSt.setString(4,"TOPRAKK");
        prSt.setString(5,"TOSUNUMM");


        System.out.println(prSt.executeUpdate());
        prSt.close();


    }

    @Test
    public void deleteAylin() throws SQLException {

        //connection

        Connection connection=DriverManager.getConnection(ConnectionManage.URL,ConnectionManage.USERNAME,ConnectionManage.PASSWORD);

        // statement + Query

        int idDelete=59;

        String queryDelete="delete from gateways where id = ?  and name = ?;";

        PreparedStatement statement = connection.prepareStatement(queryDelete);

        statement.setInt(1,idDelete);
        statement.setString(2,"aylin");

        System.out.println(statement.executeUpdate());

        String queryControl="select * from gateways where id = ? and name = ? ";
        PreparedStatement statement1=connection.prepareStatement(queryControl);

        statement1.setInt(1,idDelete);
        statement1.setString(2,"aylin");

        ResultSet resultSet=statement1.executeQuery();


        Assert.assertFalse(resultSet.next());

        connection.close();



    }

}
