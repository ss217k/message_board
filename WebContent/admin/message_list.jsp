<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>留言板</title>
        <link rel="stylesheet" href="/message_board/css/index.css">
        <script type="text/javascript">
            
        </script>
    </head>

    <body>
        <header>
            <div class="container">
                <% if (null != request.getSession().getAttribute("existUser")) {%>
                    <nav>
                        <a href="/message_board/MessageServlet?method=findOne">我的留言</a>
                    </nav>
                    <nav>
                        <a href="/message_board/admin/user.jsp?method=show">我的信息</a>
                    </nav>
                <%} else { %>
                    <nav>
                        <a href="/message_board/login.jsp">登录</a>
                        <a href="/message_board/reg.jsp">注册</a>
                    </nav>
                <% } %>
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>周岩留言板</h1>
                    <p> </p>
                </div>
            </div>
        </section>
        <section class="main">
            <div class="container">
                <c:forEach var="m" items="${pageBean.list }">
                    <div class="alt-item">
                        <div class="alt-head">
                            <div class="alt-info">
                                <span>作者：<a href="">${m.username }</a></span>
                                <span>时间：${m.createTime }</span>
                            </div>
                        </div>
                        <div class="alt-content">
                            <h3>${m.title }</h3>
                            <p>${m.content }</p>
                        </div>
                    </div>
               </c:forEach>
            </div>
        </section>
        <section class="page">
            <div id="pagefy">
       		<ul>
       		<form id="" action="" method="post">
       			<c:if test="${pageBean.page!=1 }">
       			<li><a href="/message_board/MessageServlet?page=1&method=findAll">首页</a></li>
       			<li><a href="/message_board/MessageServlet?page=${pageBean.page-1 }&method=findAll">上一页</a></li>
       			</c:if>
       			<c:forEach var="i" begin="1" end="${pageBean.totalPage }">
       			<c:if test="${pageBean.page==i }">
       			<li><span class="first-page">${i }</span></li>
       			</c:if>
       			<c:if test="${pageBean.page!=i }">
       			<li><a href="/message_board/MessageServlet?page=${i }&method=findAll">${i }</a></li>
       			</c:if>
       			</c:forEach>
       			<c:if test="${pageBean.page!=pageBean.totalPage }">
       			<li><a href="/message_board/MessageServlet?page=${pageBean.page+1 }&method=findAll">下一页</a></li>
       			<li><a href="/message_board/MessageServlet?page=${pageBean.totalPage }&method=findAll">尾页</a></li>
       			</c:if>	
       		</ul>
			</form>
       
            </div>
        </section>
        <footer>
            copy@周岩
        </footer>
    </body>
</html>