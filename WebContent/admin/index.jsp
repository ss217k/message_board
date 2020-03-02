<%@ page contentType="text/html;charset=UTF-8"%>
<html>
	<head>
		<title>MessageBoard</title>
		<!-- meta标签的作用是：访问index.jsp页面时会跳转到MessageServlet -->
		<meta http-equiv='refresh' content='0;url=<%=request.getContextPath()%>/MessageServlet'>
		<!-- 定义MessageServlet，查询所有信息，然后跳转到message_list.jsp显示所有留言 -->
	</head>
</html>