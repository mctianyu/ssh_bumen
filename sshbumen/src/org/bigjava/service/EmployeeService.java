package org.bigjava.service;

import org.bigjava.domain.Employee;
import org.bigjava.domain.PageBean;

/**
 * Ա��ҵ�����Ľӿ�
 * @author zy
 *
 */
public interface EmployeeService {
	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
