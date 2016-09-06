<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
<h1>登入成功</h1>
</body>
</html>
<script>
	window.parent.document.getElementById('cboxClose').click();
	window.parent.document.querySelectorAll(".headerDiv .members li")[1].style.display = "none";
	window.parent.document.querySelectorAll(".headerDiv .members li")[2].style.display = "none";
</script>