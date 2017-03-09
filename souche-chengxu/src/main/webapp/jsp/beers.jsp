<%@ page import="com.wuxi.service.Say"  language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>name:${name}</p>
	<p>color:${color}</p>
	<p id="area">地址:<span id="addr"></span></p>
	<p>计数：<%= Say.getCount()%></p>
</body>
<script type="text/javascript">
	document.getElementById("addr").innerText = "${addr}";
	console.log("${addr}");
</script>
</html>