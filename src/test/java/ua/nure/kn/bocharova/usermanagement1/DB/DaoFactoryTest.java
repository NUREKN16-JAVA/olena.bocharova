package ua.nure.kn.bocharova.usermanagement1.DB;

import static org.junit.Assert.*;



import junit.framework.TestCase;

public class DaoFactoryTest extends TestCase {

	

	
	public void testGetUserDao() {
		try {
			DaoFactory daoFactory=DaoFactory.getInstance();
			assertNotNull("DaoFactory instance is null", daoFactory);
			UserDAO userDao = daoFactory.getUserDao();
			assertNotNull("UserDao instance is null", userDao);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail(e.toString());
		}
		
	}

}
