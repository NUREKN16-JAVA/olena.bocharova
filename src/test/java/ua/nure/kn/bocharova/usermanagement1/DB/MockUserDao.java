package ua.nure.kn.bocharova.usermanagement1.DB;

import java.util.Collection;

import ua.nure.kn.bocharova.usermanagement1.User;

public class MockUserDao implements UserDAO {

	@Override
	public User create(User user) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public User find(Long id) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> findAll() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		// TODO Auto-generated method stub

	}

}
