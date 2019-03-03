<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }
.button {
    background-color: #f44336;
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
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工管理</td>
</tr>
<tr>
<td align="right" > <a href="${ pageContext.request.contextPath }/employee_saveUI.action" class="button">添加</a></td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
  <tr>
<td align="center">编号</td>
<td align="center">员工姓名</td>
<td align="center">性别</td>
<td align="center">出生日期</td>
<td align="center">入职时间</td>
<td align="center">所属部门</td>
<td align="center">编辑</td>
<td align="center">删除</td>
</tr>
</thead>
<tbody>
<s:iterator value="list" var="e">
<tr>
<td align="center"><s:property value="#e.eno"/></td>
<td align="center"><s:property value="#e.ename"/></td>
<td align="center"><s:property value="#e.sex"/></td>
<td align="center"><s:date name="#e.birthday" format="yyyy-MM-dd"/></td>
<td align="center"><s:date name="#e.joinDate" format="yyyy-MM-dd"/></td>
<td align="center"><s:property value="#e.department.dname"/></td>
<td align="center"><a href="${ pageContext.request.contextPath }/employee_edit.action?eid=<s:property value="#e.eid"/>"><img src="${ pageContext.request.contextPath }/frame/img/bianji1.jpg"</a></a></td>
<td align="center"><a href="${ pageContext.request.contextPath }/employee_delete.action?eid=<s:property value="#e.eid"/>"><img src="${ pageContext.request.contextPath }/frame/img/shanchu.jpg"</a></a></td>
</tr>
</s:iterator>
</tbody>
</table>
<br/>

<table table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>

<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
   <span>总记录数:<s:property value="totalCount"/>&nbsp;&nbsp;每页显示:<s:property value="pageSize"/>页</span>&nbsp;&nbsp;
  <span>
   <s:if test="currPage != 1">
       <a href="${ pageContext.request.contextPath }/employee_findAll.action?currPage=1" class="button">[首页]</a>&nbsp;&nbsp;
       <a href="${ pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="currPage-1"/>" class="button">[上一页]</a>&nbsp;&nbsp;
       </s:if>
       <s:if test="currPage != totalpage">
       <a href="${ pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="currPage+1"/>" class="button">[下一页]</a>&nbsp;&nbsp;
       <a href="${ pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="totalPage"/>" class="button">[尾页]</a>&nbsp;&nbsp;
       </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>