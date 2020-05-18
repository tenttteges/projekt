package projekt.bazydanych.DAO;

import java.util.List;

import projekt.bazydanych.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
}
