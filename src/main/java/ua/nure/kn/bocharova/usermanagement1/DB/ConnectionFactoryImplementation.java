package ua.nure.kn.bocharova.usermanagement1.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryImplementation implements ConnectionFactory {

	public ConnectionFactoryImplementation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Connection createConnection() throws DatabaseException {
		 String driver ="org.hsqldb.jdbcDriver";
		 String url="jdbc:hsqldb:file:db/usermanagement1";
		 String user ="sa";
		 String password="";
		 
		 try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			
			throw new DatabaseException(e);
		}
		 try {
		return DriverManager.getConnection(url, user, password);
	}catch(SQLException e) {
		throw new DatabaseException(e);
	}

}
