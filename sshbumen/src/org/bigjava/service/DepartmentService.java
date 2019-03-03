package org.bigjava.service;

import java.util.List;

import org.bigjava.domain.Department;
import org.bigjava.domain.PageBean;

/**
 * ���Ź����ҵ���Ľӿ�
 * @author zy
 *
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

	

	

}
