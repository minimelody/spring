<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 정보</title>
</head>
<body>
<%-- model 객체에 담은 것은 바로 key 값으로 사용됨 
ModelAndView view = new ModelAndView();
 ex) view.addObject("mem",m);
-> 사용시 ${mem.name}--%>
	
<h3>회원 정보</h3>
<form action="/mUpdate.do" method="post">
ID : <input type="text" name="userId" value="${mem.userId}" readonly><br>
PW : <input type="password" name="userPw" value="000000"><br>
PW_re : <input type="password" name="userPw_re" value="000000"><br>
NAME : <input type="text" name="userName" value="${mem.userName }" readonly><br>
PHONE : <input type="text" name="userPhone" value="${mem.userPhone }"><br>
<input type="submit" value="회원정보변경" />
</form>
</body>
</html>