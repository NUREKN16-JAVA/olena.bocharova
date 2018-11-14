package ua.nure.kn.bocharova.usermanagement1;


import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;



public class UserTest { 
	private static final String LAST_NAME = "Bocharova";
	private static final String FIRST_NAME = "Alena";
	
	private User user;
	
	private Date dateOfBirth;
	

	protected void setUp() throws Exception {
		
		user=new User();
		
		
	}	
	
	//получение полного имени
	public void testGetFullName() {
		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		
		
		assertEquals("Bocharova, Alena",(String)user.getFullName());
	}
	

	
	//др сегодня
		public void testGetAge0() throws ParseException{
			Date d = new Date();
		user.setDateOfBirth( d);
		assertEquals(0, user.getAge());
		}
		
		//др будет завтра
		public void testGetAge1() throws ParseException{
			Date d = new Date();
	       Calendar c = Calendar.getInstance();
	       c.setTime(d);
	       c.add(Calendar.DATE, 1);
	       d = c.getTime();
		user.setDateOfBirth( d);
		assertEquals(0, user.getAge());
		}
	
//	др был 10 лет назад
	public void testGetAge2(){
		 Date d = new Date();//текущая дата
	        Calendar c = Calendar.getInstance();
	        c.setTime(d);
	        c.add(Calendar.YEAR, -10);
	        d = c.getTime();
		user.setDateOfBirth( d);
		assertEquals(10, user.getAge());
	}
	
	//др был 2 дня назад
	public void testGetAge3() throws ParseException{
		 Date d = new Date();
	        Calendar c = Calendar.getInstance();
	        c.setTime(d);
	        c.add(Calendar.DATE, -2);
	        d = c.getTime();
		user.setDateOfBirth( d);
		assertEquals(0, user.getAge());
	}
	
	
	//др был год назад и на день раньше
		public void testGetAge4() throws ParseException{
			Date d = new Date();
	       Calendar c = Calendar.getInstance();
	       c.setTime(d);
	       c.add(Calendar.YEAR, -1);
	       c.add(Calendar.DATE, -1 );
	       d = c.getTime();
		user.setDateOfBirth( d);
		assertEquals(1, user.getAge());
		}
	
	//др был год назад но на день позже
	public void testGetAge5() throws ParseException{
		Date d = new Date();
       Calendar c = Calendar.getInstance();
       c.setTime(d);
       c.add(Calendar.YEAR, -1);
       c.add(Calendar.DATE, 1 );
       d = c.getTime();
	user.setDateOfBirth( d);
	assertEquals(0, user.getAge());
	}
	
	

}
