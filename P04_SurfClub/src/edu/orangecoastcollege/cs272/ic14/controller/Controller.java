package edu.orangecoastcollege.cs272.ic14.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import edu.orangecoastcollege.cs272.ic14.model.DBModel;
import edu.orangecoastcollege.cs272.ic14.model.Employee;
import edu.orangecoastcollege.cs272.ic14.model.Position;
import edu.orangecoastcollege.cs272.ic14.model.User;
import edu.orangecoastcollege.cs272.ic14.model.VideoGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {

	private static Controller theOne;

//	private static final String DB_NAME1 = "vg_inventory.db";
	private static final String DB_NAME = "surf_club.db";
	
	
	private static final String USER_TABLE_NAME = "user";
	private static final String[] USER_FIELD_NAMES = { "id", "name", "email", "role", "password"};
	private static final String[] USER_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "TEXT"};

	private static final String VIDEO_GAME_TABLE_NAME = "video_game";
	private static final String[] VIDEO_GAME_FIELD_NAMES = { "id", "name", "platform", "year", "genre", "publisher"};
	private static final String[] VIDEO_GAME_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "INTEGER", "TEXT", "TEXT"};
	private static final String VIDEO_GAME_DATA_FILE = "videogames_lite.csv";

	private static final String EMPLOYEE_TABLE_NAME = "employee";
	private static final String[] EMPLOYEE_FIELD_NAMES = { "id", "first_name", "last_name", "position", "date_hired", "gender", "ssn", "wage"};
	private static final String[] EMPLOYEE_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT"};
	
	private static final String USER_GAMES_TABLE_NAME = "user_games";
	private static final String[] USER_GAMES_FIELD_NAMES = { "user_id", "game_id"};
	private static final String[] USER_GAMES_FIELD_TYPES = { "INTEGER", "INTEGER"};

	private User mCurrentUser;
	private DBModel mVideoGameDB;
	private DBModel mUserDB;
	private DBModel mEmployeeDB;
	private DBModel mUserGamesDB;
	
	private ObservableList<Employee> mAllEmployeesList;
	private ObservableList<User> mAllUsersList;
	private ObservableList<VideoGame> mAllGamesList;

	private Controller() {
	}

	public static Controller getInstance() {
		if (theOne == null) {
			theOne = new Controller();
			theOne.mAllUsersList = FXCollections.observableArrayList();
			theOne.mAllEmployeesList = FXCollections.observableArrayList();

			try {
				theOne.mUserDB = new DBModel(DB_NAME, USER_TABLE_NAME, USER_FIELD_NAMES, USER_FIELD_TYPES);

				ArrayList<ArrayList<String>> resultsList = theOne.mUserDB.getAllRecords();
				for (ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String name = values.get(1);
					String email = values.get(2);
					String role = values.get(3);
					theOne.mAllUsersList.add(new User(id, name, email, role));
					
				}
				
				theOne.mEmployeeDB = new DBModel(DB_NAME, EMPLOYEE_TABLE_NAME, EMPLOYEE_FIELD_NAMES, EMPLOYEE_FIELD_TYPES);
				ArrayList<ArrayList<String>> employeeRS = theOne.mEmployeeDB.getAllRecords();
				
				for (ArrayList<String> values : employeeRS)
				{
					int id = Integer.parseInt(values.get(0));
					String firstName = values.get(1);
					String lastName = values.get(2); 
					String position = values.get(3);
					String dateHired = values.get(4);
					String gender = values.get(5);
					String ssn = values.get(6);
					double wage = Double.parseDouble(values.get(7));
					theOne.mAllEmployeesList.add(new Employee(id, firstName, lastName, position, dateHired, gender, ssn, wage));
				}
			}	catch (SQLException e) {
					e.printStackTrace();
				}
				

			} 
		
		return theOne;
	}

	public boolean isValidPassword(String password)
	{
		// Valid password must contain (see regex below):
		// At least one lower case letter
		// At least one digit
		// At least one special character (@, #, $, %, !)
		// At least one upper case letter
		// At least 8 characters long, but no more than 16
		return password.matches("((?=.*[a-z])(?=.*d)(?=.*[@#$%!])(?=.*[A-Z]).{8,16})");
	}

	public boolean isValidEmail(String email)
	{
		return email.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

	public String signUpUser(String name, String email, String password)
	{
	    // TODO: Validate email address
	    // Check to see if the user exists already
	    for (User user : theOne.mAllUsersList)
	        if (user.getEmail().equalsIgnoreCase(email))
	            return "Email already exists.";
	    // Now create a new User object, add to ObservableList and database
	    // Add the user to the databse (keep track of new id generated)
	    String[] values = {name, email, "STANDARD", password};
	    try
        {
            int id = theOne.mUserDB.createRecord(Arrays.copyOfRange(USER_FIELD_NAMES,1,USER_FIELD_NAMES.length), values);
            User newUser = new User(id, name, email, "STANDARD");
            theOne.mAllUsersList.add(newUser);
            theOne.mCurrentUser = newUser;
            return "SUCCESS";
        }
        catch (SQLException e)
        {
            return "Account not created.  Please try again.";
        }
	    // Let's make a user



	}

	public String signInUser(String email, String password) {

	    // Loop through the ObservableList, see if email matches
	    for (User user : theOne.mAllUsersList)
	    {
	        if (user.getEmail().equalsIgnoreCase(email))
	        {
	            // Query the database for the password:
	            try
                {
                   ArrayList<ArrayList<String>> resultsList = theOne.mUserDB.getRecord(String.valueOf(user.getId()));

                    String storedPassword = resultsList.get(0).get(4);
                    if (password.equals(storedPassword))
                    {
                        theOne.mCurrentUser = user;
                        return "SUCCESS";
                    }
                    else
                        return "Password incorrect. Please try again";
                }
                catch (SQLException e)                {

                    e.printStackTrace();
                }
	        }


	    }
		return "Email and password combination incorrect. Please try again.";
	}

	public ObservableList<VideoGame> getGamesForCurrentUser()
	{
		ObservableList<VideoGame> userGamesList = FXCollections.observableArrayList();
		// Query the User Games table, get all the game ids for that user:
		try
        {
            ArrayList<ArrayList<String>> resultsList = theOne.mUserGamesDB.getRecord(String.valueOf(mCurrentUser.getId()));
            for (ArrayList<String> values : resultsList)
            {
                // Grab the game id from the result set:
                int gameId = Integer.parseInt(values.get(1));
                // Search through the ObservableList of VideoGAmes to find game id
                for (VideoGame vg:theOne.mAllGamesList)
                {
                    if(vg.getId() == gameId)
                    {
                        userGamesList.add(vg);
                    }
                }
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


		return userGamesList;
	}

	public boolean addGameToUsersInventory(VideoGame selectedGame)
	{
	    // Get all the games for the current user:
	    ObservableList<VideoGame> gamesForCurrentUser = theOne.getGamesForCurrentUser();
	    // Loop through games, if duplicates return false

        if (gamesForCurrentUser.contains(selectedGame)) return false;
        String[] values = {String.valueOf(mCurrentUser.getId()), String.valueOf(selectedGame.getId())};
        try
        {
            theOne.mUserGamesDB.createRecord(USER_GAMES_FIELD_NAMES, values);
        }
        catch (SQLException e)
        {
           return false;
        }

		return true;
	}


	public User getCurrentUser()
	{
		return mCurrentUser;
	}


	public ObservableList<User> getAllUsers() {
		return theOne.mAllUsersList;
	}

	public ObservableList<VideoGame> getAllVideoGames() {
		return theOne.mAllGamesList;
	}

	public ObservableList<String> getDistinctPlatforms() {
		ObservableList<String> platforms = FXCollections.observableArrayList();
		for (VideoGame vg : theOne.mAllGamesList)
			if (!platforms.contains(vg.getPlatform()))
				platforms.add(vg.getPlatform());
		FXCollections.sort(platforms);
		return platforms;
	}

	public ObservableList<String> getDistinctPublishers() {
		ObservableList<String> publishers = FXCollections.observableArrayList();
		for (VideoGame vg : theOne.mAllGamesList)
			if (!publishers.contains(vg.getPublisher()))
				publishers.add(vg.getPublisher());
		FXCollections.sort(publishers);
		return publishers;
	}



//	private int initializeVideoGameDBFromFile() throws SQLException {
//		int recordsCreated = 0;
//
//		// If the result set contains results, database table already has
//		// records, no need to populate from file (so return false)
//		if (theOne.mUserDB.getRecordCount() > 0)
//			return 0;
//
//		try {
//			// Otherwise, open the file (CSV file) and insert user data
//			// into database
//			Scanner fileScanner = new Scanner(new File(VIDEO_GAME_DATA_FILE));
//			// First read is for headings:
//			fileScanner.nextLine();
//			// All subsequent reads are for user data
//			while (fileScanner.hasNextLine()) {
//				String[] data = fileScanner.nextLine().split(",");
//				// Length of values is one less than field names because values
//				// does not have id (DB will assign one)
//				String[] values = new String[VIDEO_GAME_FIELD_NAMES.length - 1];
//				values[0] = data[1].replaceAll("'", "''");
//				values[1] = data[2];
//				values[2] = data[3];
//				values[3] = data[4];
//				values[4] = data[5];
//				theOne.mVideoGameDB.createRecord(Arrays.copyOfRange(VIDEO_GAME_FIELD_NAMES, 1, VIDEO_GAME_FIELD_NAMES.length), values);
//				recordsCreated++;
//			}
//
//			// All done with the CSV file, close the connection
//			fileScanner.close();
//		} catch (FileNotFoundException e) {
//			return 0;
//		}
//		return recordsCreated;
//	}
	
	public ObservableList<String> getAllPositions()
	{
		
		ObservableList<String> mAllPositions = FXCollections.observableArrayList();
		mAllPositions.add("JANITOR");
		mAllPositions.add("CASHIER");
		mAllPositions.add("ASSISTANT");
		FXCollections.sort(mAllPositions);
		return mAllPositions;
		
		
	}
	public ObservableList<String> getGender()
	{
		ObservableList<String> mGenderList = FXCollections.observableArrayList();
		mGenderList.add("FEMALE");
		mGenderList.add("MALE");
		FXCollections.sort(mGenderList);
		return mGenderList;
	}

	public boolean createNewEmployee(String firstName, String lastName, String position, String dateHired, String gender, String ssn, double wage) 
	{
		String[] values = {firstName, lastName, position, dateHired, gender, ssn, String.valueOf(wage)};
		
		try {
//			for(String v :values)
//				System.out.println(v);
			
//			System.out.println("add into list");
//			ResultSet rs = theOne.mEmployeeDB.getAllRecords();
//			
//			System.out.println("read result set");
//			if (theOne.mEmployeeDB.getRecordCount() == 0) System.out.println("database has no records");
//			
//			System.out.println("after");
			String[] a = {"first_name", "last_name", "position", "date_hired", "gender", "ssn", "wage"};
			int id = theOne.mEmployeeDB.createRecord(a, values);
			mAllEmployeesList.add(new Employee(id, firstName, lastName, position, dateHired, gender, ssn, wage));
			System.out.println("create id");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}
		return true;
	}

	public ObservableList<Employee> getAllEmployees() {
		
		return theOne.mAllEmployeesList;
	}

	public void deleteEmployee(Employee selectedItem) 
	{
		try {
			mEmployeeDB.deleteRecord(String.valueOf(selectedItem.getId()));
			mAllEmployeesList.remove(selectedItem);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}