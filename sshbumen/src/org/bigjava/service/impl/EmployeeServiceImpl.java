package org.bigjava.service.impl;

import java.util.List;

import org.bigjava.dao.EmployeeDao;
import org.bigjava.domain.Employee;
import org.bigjava.domain.PageBean;
import org.bigjava.service.EmployeeService;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
/**
 * 员工管理的业务层实现类
 * @author zy
 *
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
     /**
      * 业务层登录的方法
      */
	@Override
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		
		return  existEmployee;
	}
	/**
	 * 分页查询员工的方法
	 */
	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin =(currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
		
	}
	@Override
	//业务层保存员工的方法
	public void save(Employee employee) {
		employeeDao.save(employee);
		
	}
	@Override
	//根据员工的id查询员工的方法
	public Employee findById(Integer eid) {
		
		return employeeDao.findById(eid);
	}
	//业务层修改员工的方法
	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
		
	}
	//业务层删除员工的方法
	@Override
	public void delete(Employee employee) {
		
		employeeDao.delete(employee);
	}
    
    
}
