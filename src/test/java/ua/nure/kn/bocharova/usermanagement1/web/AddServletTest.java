package ua.nure.kn.bocharova.usermanagement1.web;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ua.nure.kn.bocharova.usermanagement1.User;

public class AddServletTest extends MockServletTestCase {

	@Before
	public void setUp() throws Exception {
		super.setUp();
		createServlet(AddServlet.class);
	}

	@Test
	public void testAdd() {
		Date date = new Date();
		User newUser = new User("John", "Doe",date);
		User user = new User(new Long(1000), "John", "Doe",date);
		getMockUserDao().expectAndReturn("create",newUser, user);
		
		
		addRequestParameter("firstName","John");
		addRequestParameter("lastName","Doe");
		addRequestParameter("date",DateFormat.getDateInstance().format(date));
		addRequestParameter("okButton","Ok");
		doPost();
		
	}
	public void testAddEmptyFirstName() {
		Date date = new Date();
		
		addRequestParameter("lastName","Doe");
		addRequestParameter("date",DateFormat.getDateInstance().format(date));
		addRequestParameter("okButton","Ok");
		doPost();
		
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error in session scope", errorMessage);
		
	}
	
	public void testAddEmptyLastName() {
		Date date = new Date();
		
		addRequestParameter("firstName","John");
		
		
		addRequestParameter("date",DateFormat.getDateInstance().format(date));
		addRequestParameter("okButton","Ok");
		doPost();
		
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error in session scope", errorMessage);
		
	}
	
	public void testAddEmptyDate() {
		Date date = new Date();
		
		addRequestParameter("firstName","John");
		addRequestParameter("lastName","Doe");
		
		addRequestParameter("okButton","Ok");
		doPost();
		
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error in session scope", errorMessage);
		
	}
	
	public void testAddEmptyDateIncorrect() {
		Date date = new Date();
		
		addRequestParameter("firstName","John");
		addRequestParameter("lastName","Doe");
		addRequestParameter("date","asdfghjkl");
		addRequestParameter("okButton","Ok");
		doPost();
		
		String errorMessage = (String) getWebMockObjectFactory().getMockSession().getAttribute("error");
		assertNotNull("Could not find error in session scope", errorMessage);
		
	}

}
