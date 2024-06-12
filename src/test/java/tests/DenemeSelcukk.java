package tests;

import manage.ConnectionManage;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.sql.*;

public class DenemeSelcukk {

	public static final String URL = ConfigReader.getProperty("URL");
	public static final String USERNAME = ConfigReader.getProperty("USERNAME");
	public static final String PASSWORD = ConfigReader.getProperty("PASSWORD");

	@Test
	public void test01() throws SQLException {
		//connection, statement, resultset, preparedStatement

		//Database ile bağlantı kurmak için conneciton class'ından
		//connection objesi oluşturup, getConnection methodu yardımı ile
		//url, username ve passwordumuzu girerek baglantiyi kurmuş olduk
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		//2. adım: bu adımda statement oluşturmamız gerekiyor.
		//bunun için javanın statement class'ından yararlanıyoruz
		//öncelikle sorguyu yapabilmemiz için bir query'e ihtiyacımız var
		//query'mizi string olarak kaydediyoruz
		//yukarda oluşturduğumuz connection üzerinden createStatement()
		//methodunu çalıştırıyoruz.
		//daha sonra ise statement üzerinden executeQuery()
		//methodunu kullanarak query'mizi bu methoda parametre olarak yazıp
		//ResultSet olarak kaydediyoruz.

		String query = "SELECT * FROM admins";
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery(query);

		while (resultSet.next()) {
			System.out.print("ID: " + resultSet.getInt(1));
			//burada 1. sütundaki int veriyi aldık (id)
			System.out.println(" Username: " + resultSet.getString("username"));
			//burada da username isimli sütündaki
			//string veriyi aldık (username)
		}
		/*resultSet.last();
		int son = resultSet.getRow();
		resultSet.first();

		for (int i = 1; i < son; i++) {
			resultSet.next();
			System.out.println(resultSet.getInt("id"));
		}*/


		//statement.executeQuery();
		//eğer tablodaki bütün bilgileri bize bir resultset olarak
		//döndürmesini istiyorsak executeQuery'yi kullanıyoruz
		//bu bize içinde tablonun verilerinin olduğu bir set döndürüyor.

		//statement.executeUpdate();
		//eğer tablodaki bilgileri değiştirmek istiyorsak
		//ve bu değişiklerin yapıldığını test etmek istiyorsak
		//(ROW AFFECTED- etkilenen satır) executeUpdate'yi kullanırız
		//ancak bu bize sadece etkilenen satırların int olarak değerini döndürür.
	}

	@Test
	public void updateSelcuk() throws SQLException {
		//1. adım

		Connection connection = DriverManager.getConnection(ConnectionManage.URL,
															ConnectionManage.USERNAME,
															ConnectionManage.PASSWORD);

		//2. adım
		String updateSql = "UPDATE subscribers SET email = 'tosun@gmail.com' WHERE id % 2 = 0;";

		Statement statement = connection.createStatement();

		System.out.println(statement.executeUpdate(updateSql));
	}
}
