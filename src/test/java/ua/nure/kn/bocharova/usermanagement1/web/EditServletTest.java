package ua.nure.kn.bocharova.usermanagement1.web;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ua.nure.kn.bocharova.usermanagement1.User;

public class EditServletTest extends MockServletTestCase {

	@Before
	public void setUp() throws Exception {
		super.setUp();
		createServlet(EditServlet.class);
	}

	@Test
	public void testEdit() {
		Date date = new Date();
		User user = new User(new Long(1000), "John", "Doe",date);
		getMockUserDao().expect("update",user);
		
		addRequestParameter("id","1000");
		addRequestParameter("firstName","John");
		addRequestParameter("lastName","Doe");
		addRequestParameter("date",DateFormat.getDateInstance().format(date));
		addRequestParameter("okButton","Ok");
		doPost();
		
	}
	public void testEditEmptyFirstName() {
		Date date = new Date();
		addRequestParameter("id","1000");
		
		addRequestParameter("lastName","Doe");
		addRequestParameter("date",DateFormat.getDateInstance().format(date));
		addRequestParameter("okButton","Ok");
		doPost();
		
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error in session scope", errorMessage);
		
	}
	
	public void testEditEmptyLastName() {
		Date date = new Date();
		addRequestParameter("id","1000");
		addRequestParameter("firstName","John");
		
		
		addRequestParameter("date",DateFormat.getDateInstance().format(date));
		addRequestParameter("okButton","Ok");
		doPost();
		
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error in session scope", errorMessage);
		
	}
	
	public void testEditEmptyDate() {
		Date date = new Date();
		addRequestParameter("id","1000");
		addRequestParameter("firstName","John");
		addRequestParameter("lastName","Doe");
		
		addRequestParameter("okButton","Ok");
		doPost();
		
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error in session scope", errorMessage);
		
	}
	
	public void testEditEmptyDateIncorrect() {
		Date date = new Date();
		addRequestParameter("id","1000");
		addRequestParameter("firstName","John");
		addRequestParameter("lastName","Doe");
		addRequestParameter("date","asdfghjkl");
		addRequestParameter("okButton","Ok");
		doPost();
		
		String errorMessage = (String) getWebMockObjectFactory().getMockSession().getAttribute("error");
		assertNotNull("Could not find error in session scope", errorMessage);
		
	}

}
