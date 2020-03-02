<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>修改个人信息</title>
        <link rel="stylesheet" href="/message_board/css/bootstrap.min.css">
        <script type="text/javascript">
        function check(){
        	 var password=document.getElementById("password").value;
     		var password1=document.getElementById("password1").value;
     		if(password!=password1){
     			alert("两次输入密码不一致！")
     			return false;
     		}
        }
       
        </script>
        <link rel="stylesheet" href="/message_board/css/add.css">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        周岩留言板个人信息
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${existUser.username}!</h1>
                <p>请斟酌后修改 ^_^</p>
            </div>
            <div class="page-header">
                <h3><small>个人信息</small></h3>
            </div>
            <form class="form-horizontal" action="/message_board/UserServlet?method=change" onsubmit="return check()" method="post">
               
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">用户 ：</label>
                    <div class="col-sm-6">
                        <input name="username" class="form-control" id="username" value="${existUser.username }" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码 ：</label>
                    <div class="col-sm-6">
                        <input name="password" class="form-control" id="password" value="">
                    </div>
                </div>
                 <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码确认 ：</label>
                    <div class="col-sm-6">
                        <input name="password1" class="form-control" id="password1" value="">
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
            </form>
        </div>
        <footer class="text-center" >
            copy@周岩
        </footer>
    </body>
</html>
