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
	
	
	
	
	public User() {
		super();
		this.id = 0L;
		this.firstName = "";
		this.lastName = "";
		this.dateOfBirth =Calendar.getInstance().getTime();
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
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
	
 

