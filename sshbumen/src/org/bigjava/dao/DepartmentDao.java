package org.bigjava.dao;

import java.util.List;

import org.bigjava.domain.Department;

/**
 * ���Ź����DAO��Ľӿ�
 * @author zy
 *
 */
public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
