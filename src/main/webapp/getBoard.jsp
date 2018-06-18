<%@page import="ac.yongin.ssy.board.vo.BoardVO"%>
<%@page import="ac.yongin.ssy.board.dao.BoardDAO"%>
<%@page import="ac.yongin.ssy.controller.HttpUtil"%>
<%@page import="ac.yongin.ssy.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 보기</title>
</head>
<body>
<div align="center">
<h2>게시글 보기</h2>

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

<%
String seq = request.getParameter("seq");
BoardVO bvo = new BoardVO();
bvo.setSeq(Integer.parseInt(seq));
BoardDAO dao = new BoardDAO();
dao.addCnt(bvo);
BoardVO board = new BoardVO();
board = dao.getBoard(bvo);
if(board !=null) {
%>

<form action="updateBoard.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td>
		<td align="left"><input name="title" type="text" value="<%=board.getTitle() %>" /></td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td align="left"><%=board.getWriter() %></td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td align="left">
		<textarea name="content" cols="40" rows="10">
		<%=board.getContent() %>
		</textarea></td>
	</tr>
	<tr>
		<td bgcolor="orange">등록일</td>
		<td align="left"><%=board.getRegDate() %></td>
	</tr>
	<tr>
		<td bgcolor="orange">조회수</td>
		<td align="left"><%=board.getCnt() %></td>
	</tr>
	<tr>
	<% if(vo.getId().equals(board.getWriter())) { %>	<td colspan="2" align="center"><input type="hidden" name="seq" value="<%=seq%>"><input type="submit" value=글수정 /></td><%} %>
	</tr>
</table>
</form>
<hr>
<a href="insertBoard.jsp">글등록</a> | <% if(vo.getId().equals(board.getWriter())) { %>
<a href="deleteBoard.do?seq=<%=seq%>">글삭제</a> |<%} %>
<a href="getBoardList.do">글목록</a>
<%} else {
	out.print("정보가 없습니다.<br>"); }%>
</div>
</body>
</html>