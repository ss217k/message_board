<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>我的留言</title>
        <link rel="stylesheet" href="/message_board/css/index.css">
        <link rel="stylesheet" href="/message_board/css/bootstrap.min.css">
        <script type="text/javascript">
           
        </script>
    </head>

    <body>
     <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/message_board/MessageServlet?method=findAll">
                        返回留言板
                    </a>
                    
                </div>
                
            </div>
            
        </nav>
        <header>
        
            <div class="container">
           
                <% if (null != request.getSession().getAttribute("existUser")) {%>
                    <nav>
                        <a href="/message_board/MessageServlet?method=findOne">我的留言</a>
                    </nav>
                    <nav>
                        <a href="/message_board/admin/user.jsp?method=show">我的信息</a>
                    </nav>
                    <nav>
                    <a href="/message_board/UserServlet?method=logout">  退出登录 </a>
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
                    <h1>周岩留言板——我的留言</h1>
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
                        <div align="right">
                            <table>
                                <tr><td>   
                                  <a href="/message_board/MessageServlet?method=update&id=${m.id }">    <button class="btn btn-primary"  type="button">修改</button>   </a>                               
                                </td>
                                <td>
                                     <a href="/message_board/AddEditMessageServlet?method=delete&id=${m.id }">   <button class="btn btn-primary" type="button">删除</button>    </a>                              
                                </td></tr>
                            </table>
                        </div>
                    </div>
                    </c:forEach>
          <a href="/message_board/admin/add_message.jsp">  <button class="btn btn-primary"  type="button">发布留言</button>  </a>                                
             
            </div>
        </section>
       <section class="page">
            <div id="pagefy">
       		<ul>
       		<form id="" action="" method="post">
       			<c:if test="${pageBean.page!=1 }">
       			<li><a href="/message_board/MessageServlet?page=1&method=findOne">首页</a></li>
       			<li><a href="/message_board/MessageServlet?page=${pageBean.page-1 }&method=findOne">上一页</a></li>
       			</c:if>
       			<c:forEach var="i" begin="1" end="${pageBean.totalPage }">
       			<c:if test="${pageBean.page==i }">
       			<li><span class="first-page">${i }</span></li>
       			</c:if>
       			<c:if test="${pageBean.page!=i }">
       			<li><a href="/message_board/MessageServlet?page=${i }&method=findOne">${i }</a></li>
       			</c:if>
       			</c:forEach>
       			<c:if test="${pageBean.page!=pageBean.totalPage }">
       			<li><a href="/message_board/MessageServlet?page=${pageBean.page+1 }&method=findOne">下一页</a></li>
       			<li><a href="/message_board/MessageServlet?page=${pageBean.totalPage }&method=findOne">尾页</a></li>
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