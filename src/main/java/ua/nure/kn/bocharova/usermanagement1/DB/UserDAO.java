package ua.nure.kn.bocharova.usermanagement1.DB;
import java.util.Collection;

import ua.nure.kn.bocharova.usermanagement1.User;


public interface UserDAO {
	/*
	 * Add new user to DB
	 * @param user with null id
	 * @return user with auto generated id
	 * 			throw DatabaseException f any error occurs with DB
	 * author master
	 */
	
	 User create(final User user) throws DatabaseException;
	 void update (final User user) throws DatabaseException;
	 void delete( final User user) throws DatabaseException;
	
	 User find(final Long id)throws DatabaseException;
	
	 Collection<User> findAll() throws DatabaseException;
	 Collection find(String firstname, String lastName)throws DatabaseException;
	
	
	void setConnectionFactory(ConnectionFactory connectionFactory);
	
	

}
