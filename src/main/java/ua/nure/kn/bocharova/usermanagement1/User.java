package ua.nure.kn.bocharova.usermanagement1;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class User implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4372553361582530036L;
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	
	
	
	 public User(String firstName, String lastName, Date date) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.dateOfBirth = date;
	    }
	    public User(Long id, String firstName, String lastName, Date date) {
	        this.id = id;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.dateOfBirth = date;
	    }
	    public User() {
	    }
	
	
	
	
	
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	//eguals   hashcode toString
	
	@Override
	public int hashCode() {
		if(this.getId()==null) {
			return 0;
		}
		return this.getId().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		if(this.getId()==null && ((User)obj).getId()==null) {
			return true;
		}
		return this.getId().equals(((User)obj).getId());
		
		
	}
	
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}
	//Get Full Name
	public Object getFullName() {
		return getLastName()+", " +getFirstName();
	}
	
	
	//Get Full Age
	public int getAge() {
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate now = LocalDate.now();
		LocalDate birth=LocalDate.parse(sdf.format(dateOfBirth),formatter);
		Period between = Period.between(birth, now);
			return between.getYears();
		
		
	}

	}
	
 


