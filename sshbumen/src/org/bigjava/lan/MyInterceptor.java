package org.bigjava.lan;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor extends AbstractInterceptor{
	@Override
	public void destroy() {
		System.out.println("执行结束>>>");
	}
	@Override
	public void init() {
		System.out.println("开始初始化执行>>>");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
       ActionContext context = ActionContext.getContext();
       Map<String, Object> session= context.getSession();
       if(session.get("loginInfo")!=null){//如果没有登录不能跳到主页
    	   String result = invocation.invoke();
    	   return result;
       }else{
    	   return "login";
       }
	
	}
	
}
