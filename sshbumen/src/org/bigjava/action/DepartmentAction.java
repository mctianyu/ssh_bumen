package org.bigjava.action;

import org.bigjava.domain.Department;
import org.bigjava.domain.PageBean;
import org.bigjava.service.DepartmentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
    //ģ������ʹ�õĶ���
	private Department department= new Department();
	@Override
	public Department getModel() {
		return department;
	}
    private Integer currPage = 1;
    
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
    //ע�벿�Ź����Service
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	//�ṩһ����ѯ����
	public String findAll(){
	
	PageBean<Department> pageBean =	departmentService.findByPage(currPage);
	//��pagebean���뵽ֵջ��
	ActionContext.getContext().getValueStack().push(pageBean);
	
	return "findAll";
	}
	//��ת��������ӵ�ҳ��ķ���
	public String saveUI(){
		return "saveUI";
	}
	//��Ӳ���ִ�еķ���
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	//�༭���ŵ�ִ�з���
	public String edit(){
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	//�޸Ĳ��ŵķ���
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	//ɾ�����ŵķ���
	public String delete(){
    department = departmentService.findById(department.getDid());
	departmentService.delete(department);	
	return "deleteSuccess";
	}
}
