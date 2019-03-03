package org.bigjava.service.impl;

import java.util.List;

import org.bigjava.dao.EmployeeDao;
import org.bigjava.domain.Employee;
import org.bigjava.domain.PageBean;
import org.bigjava.service.EmployeeService;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
/**
 * Ա�������ҵ���ʵ����
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
      * ҵ����¼�ķ���
      */
	@Override
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		
		return  existEmployee;
	}
	/**
	 * ��ҳ��ѯԱ���ķ���
	 */
	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ�ļ�¼��
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin =(currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
		
	}
	@Override
	//ҵ��㱣��Ա���ķ���
	public void save(Employee employee) {
		employeeDao.save(employee);
		
	}
	@Override
	//����Ա����id��ѯԱ���ķ���
	public Employee findById(Integer eid) {
		
		return employeeDao.findById(eid);
	}
	//ҵ����޸�Ա���ķ���
	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
		
	}
	//ҵ���ɾ��Ա���ķ���
	@Override
	public void delete(Employee employee) {
		
		employeeDao.delete(employee);
	}
    
    
}
