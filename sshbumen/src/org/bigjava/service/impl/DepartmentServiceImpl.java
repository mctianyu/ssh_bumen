package org.bigjava.service.impl;

import java.util.List;

import org.bigjava.dao.DepartmentDao;
import org.bigjava.domain.Department;
import org.bigjava.domain.PageBean;
import org.bigjava.service.DepartmentService;
import org.springframework.transaction.annotation.Transactional;
/**
 * ���Ź����ҵ����ʵ����
 * @author zy
 *
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
      //ע�벿�Ź����DAO
	private DepartmentDao departmentDao;
	private Object getHibernateTemplate;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	//��ҳ��ѯ���ֵķ���
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ��¼��
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼����
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin = (currPage - 1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//ҵ��㱣�沿�ŵķ���
	public void save(Department department) {
	departmentDao.save(department);
	}

	@Override
	//ҵ�����ݲ���id��ѯ���ŵķ���
	public Department findById(Integer did) {
		
		return departmentDao.findById(did);
	}

	@Override
	//ҵ������id�޸Ĳ��ŵķ���
	public void update(Department department) {
	departmentDao.update(department);	
		
	}

	@Override
	//ҵ���ɾ�����ŵķ���
	public void delete(Department department) {
		departmentDao.delete(department);
		
	}
    //��ѯ���в��ŵķ���
	@Override
	public List<Department> findAll() {
		
		return departmentDao.findAll();
	}

	
	
}
