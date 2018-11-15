package ua.nure.kn.bocharova.usermanagement1.DB;

import static org.junit.Assert.*;

import java.sql.Date;

import org.dbunit.DatabaseTestCase;
import org.junit.Before;
import org.junit.Test;

import ua.nure.kn.bocharova.usermanagement1.User;

public class HsqldbDaoUserTest  extends DatabaseTestCase{
	private HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		
	}

	@Test
	public void testCreate() {
		User user= new User();
		user.setFirstName("Ivan");
		user.setLastName("Ivanov");
		user.setDateOfBirth(new Date());
		assertNull(user.getId());
		
		User userCreated = dao.create(user);
		assertNull(userCreated);
		assertNull(user.getFirstName(),userCreated.getFirstName());
		assertNull(user.getLastName(),userCreated.getLastName());
	}

}
