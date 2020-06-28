package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.TvshowDao;
import entity.Tvshow;

public class Menu {
	
	private TvshowDao tvshowDao = new TvshowDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display all employees' favorite TV shows", 
			"Display an employees' favorite TV show", 
			"Add a favorite TV show", 
			"Delete an employee's favorite TV show",
			"Update an employee's favorite TV show");

	public void start() {
		//use selects an option from the menu and performs a specific functionality depending on which option is picked
		String selection = "";
		
		//create a loop that always executes at least once to allow the user to perform actions on the menu over and over without
		//needing to start the menu over; continue to execute until user decides to exit 
		//use a do-while loop
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
			if (selection.equals("1")) {
				displayTvshows();
			} else if (selection.equals("2")) {
				displayTvshow();
			} else if (selection.equals("3")) {
				createTvshow();
			} else if (selection.equals("4")) {
				deleteTvshow();
			} else if (selection.equals("5")) {
				updateTvshow();
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			System.out.println("Press enter to continue...");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n-------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ")" + options.get(i));
		}
	}
	
	private void displayTvshows() throws SQLException {
		List<Tvshow> tvshows = tvshowDao.getTvshows();
		for(Tvshow tvshow : tvshows) {
			System.out.println(tvshow.getEmployeeId() + ": " + tvshow.getTvShow());
		}
	}
	
	private void displayTvshow() throws SQLException {
		System.out.print("Enter employee id: ");
		//parseInt turns the integer input by the user into an integer rather than keeping it as a string
		int id = Integer.parseInt(scanner.nextLine());
		Tvshow tvshow = tvshowDao.getTvshowByID(id);
		System.out.println(tvshow.getEmployeeId() + ": " + tvshow.getTvShow());
	}
	
	private void createTvshow() throws SQLException {
		System.out.print("Enter employee's First Name:");
		String firstName = scanner.nextLine();
		System.out.print("Enter employee's Last Name:");
		String lastName = scanner.nextLine();
		System.out.print("Enter employee's favorite TV Show:");
		String tvshow = scanner.nextLine();
		tvshowDao.createNewTvshow(firstName, lastName, tvshow);
	}
	
	private void deleteTvshow() throws SQLException {
		System.out.print("Enter the employee ID to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		tvshowDao.deleteTvshowByID(id);
	}
	
	private void updateTvshow() throws SQLException {
		System.out.print("Enter employee ID:");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter their new favorite TV Show:");
		String tvshow = scanner.nextLine();
		tvshowDao.updateTVshowByID(id, tvshow);
	}
}