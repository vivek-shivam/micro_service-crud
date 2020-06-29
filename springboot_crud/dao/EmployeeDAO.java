package vivek.springboot_crud.springboot_crud.dao;

import java.util.List;

import vivek.springboot_crud.springboot_crud.model.Employee;

public interface EmployeeDAO {
	
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
}
