package org.bigjava.action;

import java.util.List;
import java.util.Map;

import org.bigjava.domain.Department;
import org.bigjava.domain.Employee;
import org.bigjava.domain.PageBean;
import org.bigjava.service.DepartmentService;
import org.bigjava.service.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * Ա�������Action��
 * @author zy
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	public String username;
	public String passworld;
	public Map<String, Object> session;
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassworld() {
		return passworld;
	}
	public void setPassworld(String passworld) {
		this.passworld = passworld;
	}
	
	//ģ������ʹ�õĶ���
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	} 
	/**
	 * ��½ִ�еķ���
	 * @return
	 */
	
     //ע��ҵ������
	private EmployeeService employeeSerivce;
    private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public void setEmployeeSerivce(EmployeeService employeeSerivce) {
		this.employeeSerivce = employeeSerivce;
	}
	//���ܵ�ǰҳ��
	private Integer currPage = 1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public String login(){
		System.out.println("login����ִ����>>>");
		//����ҵ������
		Employee existEmployee = employeeSerivce.login(employee);
		if(existEmployee == null){
			//��¼ʧ��
			this.addActionError("�û������������!");
			return ERROR;
		}else{
			//��¼�ɹ�
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
		}
	/**
	 * ��ҳ��ѯԱ����ִ�з���
	 */
	public String findAll(){
		
		PageBean<Employee> pageBean = employeeSerivce.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "findAll";
	}
	/**
	 * ��ת�����Ա��ҳ��ִ�еķ���
	 */
	public String saveUI(){
		//��ѯ���в���
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
	return "saveUI";
	}
	//����Ա��ִ�еķ���
	public String save(){
		 employeeSerivce.save(employee);
		return "saveSuccess";
	}
	/**
	 * �༭Ա����ִ�з���
	 */
	public String edit(){
		//����Ա��ig��ѯԱ��
		employee = employeeSerivce.findById(employee.getEid());
		//��ѯ���в���
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "editSuccess";
	}
	//�޸�Ա��ִ�еķ���
	public String update(){
		employeeSerivce.update(employee);
		return "updateSuccess";
	}
	//ɾ��Ա��ִ�еķ���
	public String delete(){
		employee = employeeSerivce.findById(employee.getEid());
		employeeSerivce.delete(employee);
		return "deleteSuccess";
	}
        }
	

