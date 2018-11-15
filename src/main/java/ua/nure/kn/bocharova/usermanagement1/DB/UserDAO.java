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
	
	public User create(final User user) throws DatabaseException;
	
	public User find(final Long id)throws DatabaseException;
	
	public Collection<User> findAll() throws DatabaseException;
	
	public update(final User user) throws  DatabaseException;
	
	public delete(final User user) throws  DatabaseException;
	 void setConnectionFactory(ConnectionFactory connectionFactory);
	
	

}
