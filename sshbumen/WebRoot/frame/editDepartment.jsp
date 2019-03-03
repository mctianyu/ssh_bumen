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
    background-color: #8080c0;
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
<td align="center" style="font-size:24px; color:#666">编辑部门</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()" class="button">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)" class="button">退回 </a>
</td>
</tr>
</table>
<br/>
 <br>
<table style="font-size:16px">
<tr>
<s:form id="saveForm" action="department_update" method="post" namespace="/" theme="simple">
 <s:hidden name="did" vlaue="%{model.did}"/>
  <td>部门名称：</td>
  <td><s:textfield name="dname" value="%{model.dname}"/></td>
</tr>
<tr>
  <td>部门介绍：</td>
  <td></td>
</tr>
<tr>
  <td width="10%"></td>
  <td>
     <s:textarea cols="50" rows="5" name="ddesc" value="%{model.ddesc}"/>
  </td>
</tr>
</table>
</s:form>
</body>
</html> 