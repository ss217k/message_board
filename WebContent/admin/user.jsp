<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>我的信息</title>
        <link rel="stylesheet" href="/message_board/css/bootstrap.min.css">
        <link rel="stylesheet" href="/message_board/css/add.css">
        <script type="text/javascript">
        	function change(){
        		window.location.href="/message_board/admin/edit_user.jsp";
        	}
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
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${existUser.username}!</h1>
                <p>信息都在这里了 ^_^</p>
            </div>
            <div class="page-header">
                <h3><small>个人信息</small></h3>
            </div>
             <form class="form-horizontal" action="" method="post">
               
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">用户 ：</label>
                    <div class="col-sm-6">
                        <input name="username" class="form-control" id="name" value="${existUser.username}" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码 ：</label>
                    <div class="col-sm-6">
                        <input name="password" class="form-control" id="password" value="${existUser.password}"readonly>
                    </div>
                </div>
               
                
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                         <button type="button" onclick="change()" class="btn btn-primary">修改信息</button>&nbsp;&nbsp;&nbsp; 
                    </div>
                </div>
            </form>
        </div>
        <footer class="text-center" >
            copy@周岩
        </footer>
    </body>
</html>
