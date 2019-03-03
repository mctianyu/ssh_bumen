package org.bigjava.dao.impl;

import java.util.List;

import org.bigjava.dao.DepartmentDao;
import org.bigjava.domain.Department;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * ���Ź���DAO��ʵ����
 * @author zy
 *
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{

	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size() >0){
			return list.get(0).intValue();
		}
		return 0;
	}
   /**
    * ��ҳ��ѯ����
    * 
    */
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}
    @Override
    //Dao�б��沿�ֵķ���
    public void save(Department department) {
	this.getHibernateTemplate().save(department);
	
}
    @Override
    //DAO�и��ݲ��ŵ�id��ѯ���ŵķ���
    public Department findById(Integer did) {
	return this.getHibernateTemplate().get(Department.class, did);
}
     @Override
     //DAO���޸Ĳ��ŵķ���
     public void update(Department department) {
	this.getHibernateTemplate().update(department);
	
   }
	@Override
	//DAO��ɾ�����ŵķ���
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
		
	}
	@Override
	//Dao�в�ѯ���в��ŵķ���
	public List<Department> findAll() {
		
		return this.getHibernateTemplate().find("from Department");
	}

}
