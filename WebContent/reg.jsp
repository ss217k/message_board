<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>注册</title>
        <link rel="stylesheet" href="css/reg.css">

        <script type="text/javascript">
            function changeImg() {
                var img = document.getElementById("img");
                img.src = "/message_board/CheckImgServlet?date=" + new Date();
            }
			function check(){
				var username=document.getElementById("username").value;
				if(username==null||username==""){
					alert("用户名不能为空！")
					return false;
				}
				var password=document.getElementById("password").value;
				var password2=document.getElementById("password2").value;
				if(password.indexOf(" ")!=-1||password.length<6||password.length>16){
					alert("密码格式不合法，请重新输入");
					return false;
				}
				if(password!=password2){
					alert("两次输入密码不一致！")
					return false;
				}
				var checkcode=document.getElementById("checkcode").value;
				if(checkcode==null||checkcode==""){
					alert("验证码不能为空！")
					return false;
				}
			}
            
        </script>
    </head>
    <body>
    <div class="reg">
        <div class="header">
            <h1>
                <a href="/message_board/login.jsp">登录</a>
                <a href="/message_board/reg.jsp">注册</a>
                <p>${info }</p>
            </h1>
            <button></button>
        </div>
        <form action="/message_board/RegistServlet" onsubmit="return check()" method="post">
            <div class="name">
                <input type="text" id="username" name="username" placeholder="请输入用户名">
                <p></p>
            </div>
            <div class="pwd">
                <input type="password" id="password" name="password" placeholder="6-16位密码，区分大小写，不能用空格">
                <p></p>
            </div>
            <div class="confirm-pwd">
                <input type="password" id="password2" placeholder="确认密码">
                <p></p>
            </div>
            <div class="idcode">
                <input type="text" id="checkcode" name="checkcode" placeholder="请输入验证码">
                <a href='#' onclick="javascript:changeImg()">&nbsp;&nbsp;&nbsp;&nbsp;换一张</a>
                <span><img id="img" src="/message_board/CheckImgServlet"style="width: 94px;height: 42px;"/></span>
                <div class="clear"></div>
            </div>
            <div class="btn-red">
                <input  type="submit" value="注册"  id="reg-btn">
            </div>
        </form>
    </div>
    </body>
</html>
