package projekt.bazydanych.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="addTimeDate")
	private Date addTimeDate;
	
	@Column(name="adress")
	private String adress;
	
	public Employee() {
		
	}

	public Employee(String firstName, String lastName, Date addTimeDate, String adress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.addTimeDate = addTimeDate;
		this.adress = adress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getAddTimeDate() {
		return addTimeDate;
	}

	public void setAddTimeDate(Date addTimeDate) {
		this.addTimeDate = addTimeDate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addTimeDate="
				+ addTimeDate + ", adress=" + adress + "]";
	}
	
	
}
