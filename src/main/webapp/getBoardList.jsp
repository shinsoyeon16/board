<%@page import="ac.yongin.ssy.board.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ac.yongin.ssy.controller.HttpUtil"%>
<%@page import="ac.yongin.ssy.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
<% // 얼럿 노출을 위한 설정
		String result = (String) request.getAttribute("result");
		if (result != null) {
			out.println("<script language='javascript'>");
			out.println("alert('" + result + "');");
			out.println("</script>");
		}
	%>
<div align="center">
<h2>게시글 목록</h2>

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


<form action="getBoard.do" method="post">
<table border="1" cellpadding="0" width="700">
<tr><td align="right">
	<select name="searchCondition">
	<option value="TITLE">제목
	<option value="CONTENT">내용
	</select>
	<input name="searchKeyword" type="text"/>
	<input type="submit" value="검색" />
	</td>
</tr>
</table>
</form>
<%
ArrayList<BoardVO> list = (ArrayList<BoardVO>) request.getAttribute("list");
BoardVO bvo = new BoardVO();
if(list!=null) { %>
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
<th bgcolor="orange" width="100">번호</th>
<th bgcolor="orange" width="200">제목</th>
<th bgcolor="orange" width="150">작성자</th>
<th bgcolor="orange" width="150">등록일</th>
<th bgcolor="orange" width="100">조회수</th>
</tr>

<%
for(int i=0;i<list.size();i++){
	bvo = list.get(i);

%>
<tr>
	<td><%=bvo.getSeq() %></td>
	<td align="left"><a href="getBoard.jsp?seq=<%=bvo.getSeq() %>"><%=bvo.getTitle() %></a></td>
	<td><%=bvo.getWriter() %></td>
	<td><%=bvo.getRegDate() %></td>
	<td><%=bvo.getCnt() %></td>
</tr>
<%} %>
</table>
<%}else {
	out.println("정보가 없습니다.<br>");
	}%>

<br>
<a href="insertBoard.jsp">새글등록</a>
</div>
</body>
</html>