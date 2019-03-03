<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<script type="text/javascript">
</script>
<style type="text/css">
.button {
    background-color: #008CBA;;
    border: none;
    color: white;
    padding: 10px 26px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    margin: 4px 2px;
    cursor: pointer;
}
    </style>
</head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()" class="button">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)" class="button">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="employee_save" method="post" namespace="/" id="saveForm" theme="simple">
<table border='0' cellpadding="0"  cellspacing="10">
<tr>
<td>姓名：</td>
<td><s:textfield name="ename" /></td>
<td>性别：</td>
<td><s:radio name="sex" list="{'男','女'}"/></td>
</tr>
<tr>
<td>用户名：</td>
<td><s:textfield name="username" /></td>
<td>密码：</td>
<td><s:password name="password" /></td>
</tr>
<tr>
<td>出生日期：</td>
<td><input type="date" value="2020-01-01" name="birthday"/></td>
<td>入职时间：</td>
<td><input type="date" value="2020-01-01" name="joinDate"/></td>
</tr>

<tr>
<td>所属部门：</td>
<td><s:select name="department.did" list="list" listKey="did" listValue="dname" headerKey="" headerValue="--请选择--"/></td>
<td>编号：</td>
<td><s:textfield name="eno"/></td>
</tr>
</table>
</s:form>

</body>
</html>