package ua.nure.kn.bocharova.usermanagement1.web;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mockobjects.dynamic.Mock;
import com.mockrunner.servlet.BasicServletTestCaseAdapter;

import ua.nure.kn.bocharova.usermanagement1.DB.DaoFactory;
import ua.nure.kn.bocharova.usermanagement1.DB.MockDaoFactory;
import ua.nure.kn.bocharova.usermanagement1.DB.MockUserDao;

public abstract class MockServletTestCase extends BasicServletTestCaseAdapter {
	
private Mock MockUserDao;

@Before
public void setUp() throws Exception {
	super.setUp();
	Properties properties = new Properties();
	properties.setProperty("dao.factory", MockDaoFactory.class.getName());
	DaoFactory.init(properties);
	setMockUserDao(((MockDaoFactory)DaoFactory.getInstance()).getMockUserDao());
}

@After
public void tearDown() throws Exception {
	getMockUserDao().verify();
	super.tearDown();
}
	public Mock getMockUserDao() {
	return MockUserDao;
}

public void setMockUserDao(Mock mockUserDao) {
	MockUserDao = mockUserDao;
}


	
}
