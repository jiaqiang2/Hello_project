<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'adminList.jsp' starting page</title>
   

  <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
  <link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript" src="js/jquery.easyui.min.js"></script></head>
  
  <body>
   	<table id="dg"></table>
   	
  </body>
  <script type="text/javascript">
   		$("#dg").datagrid({
   			url:"${pageContext.request.contextPath}/admin/find",
   			columns:[[
   				{field:'id',title:'编号',width:100},
   				{field:'username',title:'用户名',width:100},
   				{field:'password',title:'密码',width:100},
   				
   			]],
   			singleSelect : true,
   			pagination : true
   		});
   	</script>
</html>
