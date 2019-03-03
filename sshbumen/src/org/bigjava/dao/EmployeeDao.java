package org.bigjava.dao;

import java.util.List;

import org.bigjava.domain.Employee;

/**
 * Ա�������dao�Ľӿ�
 * @author zy
 *
 */
public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	List<Employee> findByPage(int begin, int pageSize);

	int findCount();

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
