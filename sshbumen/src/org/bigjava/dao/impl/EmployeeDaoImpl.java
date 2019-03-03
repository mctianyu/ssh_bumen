package org.bigjava.dao.impl;

import java.util.List;

import org.bigjava.dao.EmployeeDao;
import org.bigjava.domain.Employee;
import org.hibernate.criterion.DetachedCriteria;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * 员工管理的DAO的实现类
 * @author zy
 *
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
     /**
      * Dao中根据用户名和密码查询方法;
      */
	
	@Override
	public  Employee findByUsernameAndPassword(Employee employee) {
		String hql="from Employee where username = ? and password = ?";
		
		List<Employee> list=this.getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
		if(list.size() >0){
			return list.get(0);
		}
		
		return null;
	}
	@Override
	public int findCount() {
		String hql="select count(*) from Employee";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list.size() >0){
			return list.get(0).intValue();
		}
		
		return 0;
	}
	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria,begin ,pageSize);
		return list;
	}
	@Override
	//DAO中的保存员工的方法
	public void save(Employee employee) {
	this.getHibernateTemplate().save(employee);
	}
	@Override
	//DAo根据员工的id查询员工的方法
	public Employee findById(Integer eid) {
		
		return this.getHibernateTemplate().get(Employee.class, eid);
	}
	//Dao中修改员工的方法
	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
		
	}
	//Dao中删除员工的方法
	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
	}
	
	
	
	
	
}
