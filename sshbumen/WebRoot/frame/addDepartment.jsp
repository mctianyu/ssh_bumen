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
<td align="center" style="font-size:24px; color:#666"> 部门添加</td>
</tr>

</table>
<br/>
 <br>
<table style="font-size:16px">
<tr>

<tr>
<s:form id="saveForm" action="department_save" method="post" namespace="/" theme="simple">
  <td>部门名称：</td>
  <td><s:textfield name="dname"/></td>
</tr>
<tr>
  <td>部门介绍：</td>
  <td></td>
</tr>
<tr>
  <td width="10%"></td>
  <td>
     <s:textarea cols="50" rows="5" name="ddesc"/>
  </td>
</tr>
<td>
<a href="javascript:document.getElementById('saveForm').submit()" class="button">添加</a>&nbsp;&nbsp; 
<a href="javascript:history.go(-1)" class="button">返回</a>
</td>
</tr>
</table>
</s:form>
</body>
</html> 