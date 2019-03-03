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
 * 员工管理的Action类
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
	
	//模型驱动使用的对象
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	} 
	/**
	 * 登陆执行的方法
	 * @return
	 */
	
     //注入业务层的类
	private EmployeeService employeeSerivce;
    private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public void setEmployeeSerivce(EmployeeService employeeSerivce) {
		this.employeeSerivce = employeeSerivce;
	}
	//接受当前页数
	private Integer currPage = 1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public String login(){
		System.out.println("login方法执行了>>>");
		//调用业务层的类
		Employee existEmployee = employeeSerivce.login(employee);
		if(existEmployee == null){
			//登录失败
			this.addActionError("用户名或密码错误!");
			return ERROR;
		}else{
			//登录成功
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
		}
	/**
	 * 分页查询员工的执行方法
	 */
	public String findAll(){
		
		PageBean<Employee> pageBean = employeeSerivce.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "findAll";
	}
	/**
	 * 跳转到添加员工页面执行的方法
	 */
	public String saveUI(){
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
	return "saveUI";
	}
	//保存员工执行的方法
	public String save(){
		 employeeSerivce.save(employee);
		return "saveSuccess";
	}
	/**
	 * 编辑员工的执行方法
	 */
	public String edit(){
		//根据员工ig查询员工
		employee = employeeSerivce.findById(employee.getEid());
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "editSuccess";
	}
	//修改员工执行的方法
	public String update(){
		employeeSerivce.update(employee);
		return "updateSuccess";
	}
	//删除员工执行的方法
	public String delete(){
		employee = employeeSerivce.findById(employee.getEid());
		employeeSerivce.delete(employee);
		return "deleteSuccess";
	}
        }
	

