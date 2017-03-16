<%@ page  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" href="http://assets.souche.com/shop/assets/sso/favicon.ico" type="image/x-icon">
	<title>啤酒</title>
</head>
<body>
	<%@ include file="head.jsp" %>
	<p>name:${name}</p>
	<p>color:${color}${param.color}</p>
	<p id="area">地址:<span id="addr"></span></p>
	<%@ include file="/jsp/foot.jsp"%>
</body>
<script type="text/javascript">
	document.getElementById("addr").innerText = "${addr}";
	console.log("${addr}");
</script>
</html>