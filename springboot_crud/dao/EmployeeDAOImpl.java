package vivek.springboot_crud.springboot_crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vivek.springboot_crud.springboot_crud.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private EntityManager entitymanager;

	@Override
	public List<Employee> get() {
		Session currentSession = entitymanager.unwrap(Session.class);
		Query<Employee> query =currentSession.createQuery("from Employee",Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee get(int id) {
		Session currentSession = entitymanager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, id);
		return employeeObj;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = entitymanager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
		
	}

	@Override
	public void delete(int id) {
		Session currentSession = entitymanager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, id);
		currentSession.delete(employeeObj);
		
	}

}
