<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>编辑留言</title>
        <link rel="stylesheet" href="/message_board/css/bootstrap.min.css">
        <link rel="stylesheet" href="/message_board/css/add.css">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/message_board/admin/message_list.jsp">
                        周岩留言板
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${existUser.username}!</h1>
                <p>既然来了，就说点什么吧</p>
            </div>
            <div class="page-header">
                <h3><small>修改留言</small></h3>
            </div>
            <form class="form-horizontal" action="/message_board/AddEditMessageServlet?method=update&id=${message.id }" method="post">
                <input type="hidden" name="id" value="">
                <div class="form-group">
                    <label for="inputTitle" class="col-sm-2 control-label">标题 ：</label>
                    <div class="col-sm-8">
                        <input name="title" class="form-control" id="inputTitle" value="${message.title }">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputContent" class="col-sm-2 control-label">内容 ：</label>
                    <div class="col-sm-8">
                        <textarea name="content" class="form-control" rows="3" " id="inputContent">${message.content }</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <a class="btn btn-default" href="/message_board/MessageServlet?method=findOne">返回</a>
                    </div>
                </div>
            </form>
        </div>
        <footer class="text-center" >
            copy@周岩
        </footer>
    </body>
</html>
