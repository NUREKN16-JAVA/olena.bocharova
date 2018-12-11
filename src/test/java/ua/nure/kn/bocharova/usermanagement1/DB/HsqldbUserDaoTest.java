package ua.nure.kn.bocharova.usermanagement1.DB;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;


import ua.nure.kn.bocharova.usermanagement1.User;

public class HsqldbUserDaoTest extends DatabaseTestCase{
	private static final Long USER_ID = 1000L;
	private static final String USER_FIRSTNAME = "Bill";
	private static final String USER_LASTNAME = "Gates";
	private static final String UPDATED_FIRSTNAME = "Alena";
	private static final String UPDATED_LASTNAME = "Bocharova";
	private static final String UPDATED_DATE_OF_BIRTH = "1998-06-20";

	private HsqldbUserDao dao;
	
	private ConnectionFactory connectionFactory;

	
	public void setUp() throws Exception {
		super.setUp();
		
		dao = new HsqldbUserDao(connectionFactory);
		
		
	}


	public void testCreate()  {
		try {
		    User user= new User();
			user.setFirstName("John");
			user.setLastName("Doe");
			user.setDateOfBirth(new Date());
			assertNull(user.getId());
			
			User userCreated = dao.create(user);
			assertNotNull(userCreated);
			assertNotNull(userCreated.getId());
			assertEquals(user.getFirstName(),userCreated.getFirstName());
			assertEquals(user.getLastName(),userCreated.getLastName());
			assertEquals(user.getDateOfBirth(),userCreated.getDateOfBirth());
		} catch (DatabaseException e) {
			
			e.printStackTrace();
			fail(e.toString());
			
		}
	
	}
	
	public void testUpdate() throws DatabaseException {
        User user = dao.find(USER_ID);
        user.setFirstName(UPDATED_FIRSTNAME);
		user.setLastName(UPDATED_LASTNAME);
		
		SimpleDateFormat dt = new SimpleDateFormat ("yyyy-MM-dd");
		Date newDateOfBirth = new Date();
		try {
			newDateOfBirth=dt.parse(UPDATED_DATE_OF_BIRTH);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
        user.setDateOfBirth(newDateOfBirth);
		
		dao.update(user);
		
		User UserUpdated = dao.find(USER_ID);
		assertEquals(UPDATED_FIRSTNAME, UserUpdated.getFirstName());
		assertEquals(UPDATED_LASTNAME, UserUpdated.getLastName());
		assertEquals(newDateOfBirth, UserUpdated.getDateOfBirth());
    }
	
	public void testDelete() throws DatabaseException {
		User user = new User();
		user.setId(USER_ID);
		try {
			dao.delete(user);
			dao.find(USER_ID);
			fail("No exception");
		} catch (DatabaseException e) {
			assertEquals("No users with id=" + USER_ID, e.getMessage());
		}
	}
	
	public void testFindAll() throws DatabaseException {
		try {
			Collection <User> collection= dao.findAll(); 
			assertNotNull("Collection is null", collection);
			assertEquals("Collection size.", 2, collection.size());
			
		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.toString());
		}
		
	}
	
	public void testFind() throws DatabaseException {
		User user = dao.find(USER_ID);
		assertNotNull("Null.", user);
		assertEquals("Firstnames are not equal.", USER_FIRSTNAME, user.getFirstName());
		assertEquals("Lastnames are not equal.", USER_LASTNAME, user.getLastName());
	}

	
	protected IDatabaseConnection getConnection() throws Exception {
		connectionFactory=new ConnectionFactoryImplementation("org.hsqldb.jdbcDriver", "jdbc:hsqldb:file:db/usermanagement1", "sa", "");
		return new DatabaseConnection(connectionFactory.createConnection());
	}

	
	protected IDataSet getDataSet() throws Exception {
	    IDataSet dataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("usersDataSet.xml"));
		return dataSet;
	}

}

