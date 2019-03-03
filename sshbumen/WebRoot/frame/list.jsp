<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<style>
.button {
    background-color: #4CAF50;
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
<td align="left" width="39%" style="font-size:24px; color:#999"> 部门管理</td>
<td width="57%" align="right">
     <a href="${ pageContext.request.contextPath }/department_saveUI.action" class="button">添加</a>
</td>
</tr>
</table>

<br/>

<table cellspacing="0" border="1" class="table1">
<thead>
   <tr><th width="450">部门名称</th><th  width="450">编辑</th>
   <th  width="450">删除</th>
   </tr>
</thead>
<tbody>
<s:iterator value="list" var="d">
<tr>
<td align="center"><s:property value="#d.dname"/></td>
<td align="center"><a href="${ pageContext.request.contextPath }/department_edit.action?did=<s:property value="#d.did"/>"> <img src="${ pageContext.request.contextPath }/images/bianji.JPG"></a></td>
<td align="center"><a href="${ pageContext.request.contextPath }/department_delete.action?did=<s:property value="#d.did"/>"> <img src="${ pageContext.request.contextPath }/images/shanchu.JPG"></a></td>
</tr>
</s:iterator>
</tbody>
</table>
<br/>


<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>
   <span>总记录数:<s:property value="totalCount"/>&nbsp;&nbsp;每页显示:<s:property value="pageSize"/></span>
   
   <s:if test="currPage != 1">
   
      <a href="${ pageContext.request.contextPath }/department_findAll.action?currPage=1" class="button">[首页]</a>&nbsp;&nbsp;
      <a href="${ pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage-1"/>" class="button">[上一页]</a>&nbsp;&nbsp;
       </s:if>
       <s:if test="currPage != totalpage">
       <a href="${ pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage+1"/>" class="button">[下一页]</a>&nbsp;&nbsp;
       <a href="${ pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="totalPage"/>" class="button">[尾页]</a>&nbsp;&nbsp;
       </s:if>
       </ul>
</td>
</tr>
</table>
</body>
</html>