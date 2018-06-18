<%@page import="ac.yongin.ssy.controller.HttpUtil"%>
<%@page import="ac.yongin.ssy.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새 글 등록</title>
</head>
<body>
<div align="center">
<h2>글 등록</h2>

<!-- 로그인 정보 확인 로직 -->
<% 
UserVO vo = (UserVO) session.getAttribute("login");
if(vo==null) {
	request.setAttribute("result", "로그인 후 이용 가능한 서비스입니다.");
	HttpUtil.forward(request, response, "login.jsp");
	return;
} else { %>
	<h3><%=vo.getId() %>님 환영합니다!! <br>
	<a href="logout.do">Log-out</a></h3>
<% } %>
<hr><br>


<form action="insertBoard.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td>
		<td align="left"><input name="title" type="text" /></td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td align="left"><input name="writer" readonly value="<%=vo.getId() %>" type="text" /></td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value=새글등록 /></td>
	</tr>
</table>
</form>
<hr>
<a href="getBoardList.do">글목록</a>
</div>
</body>
</html>