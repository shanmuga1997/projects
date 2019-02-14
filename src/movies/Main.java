package movies;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SQLException {
		Movies movies=new Movies();
        Scanner in=new Scanner(System.in);		
		
		
		
		System.out.println("Enter the starting letter");
		String letter=in.next();
		ArrayList<String> moviesList=movies.getMoviesList(letter);
		if(moviesList!=null)
		{
			for(String list : moviesList)
			{
				
				System.out.println(list);
			}
		}
		else
		{
			System.out.println("Movies does not exists!!!");
		}
		
		
	}

}
