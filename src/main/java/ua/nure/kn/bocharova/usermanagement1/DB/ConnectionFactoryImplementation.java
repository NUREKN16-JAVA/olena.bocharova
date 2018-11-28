package ua.nure.kn.bocharova.usermanagement1.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryImplementation implements ConnectionFactory {

	private String driver;
	private String url;
	private String user;
	private String password;
	
	
	public ConnectionFactoryImplementation(String driver, String url, String user, String password) {
		this.driver = driver;
		this.driver = url;
		this.driver = user;
		this.driver = password;
		
	}

	@Override
	public Connection createConnection() throws DatabaseException {
		
		 
		 try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			
			throw new RuntimeException(e);
		}
		 try {
		return DriverManager.getConnection(url, user, password);
	}catch(SQLException e) {
		throw new DatabaseException(e);
	}

}
}