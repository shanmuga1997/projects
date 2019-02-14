package movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Movies {
	private String name;
	private float price;
	private int id;

	private Connection connection;

	public Movies() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			connection = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<String> getMoviesList(String letter) throws SQLException {
		ArrayList<String> MoviesList = new ArrayList<>();
		PreparedStatement stmt;
		stmt = connection.prepareStatement("select id,name,price from movies where name like ? order by name asc");
		letter = letter + "%";
		stmt.setString(1, letter);
		ResultSet rs = stmt.executeQuery();
		String temp;

		int rows = rs.getRow();
		System.out.println(rows);
		if (rows == 0) {
			MoviesList=null;
		} else {
			temp = "Id  Name  Price";
			MoviesList.add(temp);

			while (rs.next()) {

				temp = rs.getInt("id") + "  " + rs.getString("name") + " "
						+ rs.getInt("price");
				MoviesList.add(temp);

			}
		}
		
		return MoviesList;

	}
}
