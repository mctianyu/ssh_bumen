<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
function showTime(){
    nowtime=new Date();
    year=nowtime.getFullYear();
    month=nowtime.getMonth()+1;
    date=nowtime.getDate();
    document.getElementById("mytime").innerText=year+"年"+month+"月"+date+" "+nowtime.toLocaleTimeString();
}
setInterval("showTime()",1000);
</script>
<style type="text/css">
.div1{ margin-top:50px; margin-left:600px; font-size:14px; color:black}
</style>
</head>

<body bgcolor="pink">
<div class="div1">
欢迎您：<s:property value="#session.existEmployee.ename"/>&nbsp;&nbsp;&nbsp;日期: <span id="mytime"></span>
</div>
</body>
</html>
