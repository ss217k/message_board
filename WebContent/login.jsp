<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>登录</title>
		<link rel="stylesheet" href="/message_board/css/login.css">

		<script type="text/javascript">
            function changeImg() {
                var img = document.getElementById("img");
                img.src = "/message_board/CheckImgServlet?date=" + new Date();
            }
   			function check(){
   				var name=document.getElementById("name").value;
        		if(name==null||name==""){
        			alert("用户名不能为空")
        			return false;
        		}
        		var pwd=document.getElementById("pwd").value;
        		if(pwd==null||pwd==""){
        			alert("密码不能为空")
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
		<div class="login">
			<div class="header">
				<h1>
					<a href="/message_board/login.jsp">登录</a>
					<a href="/message_board/reg.jsp">注册</a>
					<p>${info }</p>
				</h1>
				<button></button>
			</div>
			<form action="/message_board/LoginServlet" onsubmit="return check()" method="post">
				<div class="name">
					<input type="text" id="name" name="username" placeholder="请输入登录用户名">
					<p></p>
				</div>
				<div class="pwd">
					<input type="password" id="pwd" name="password" placeholder="6-16位密码，区分大小写，不能用空格">
					<p></p>
				</div>
				<div class="idcode">
					<input type="text" name="checkcode" id="checkcode" placeholder="请输入验证码">
					<a href='#' onclick="javascript:changeImg()">&nbsp;&nbsp;&nbsp;&nbsp;换一张</a>
					<span><img id="img" src="/message_board/CheckImgServlet" style="width: 94px;height: 42px;"/></span>
					<div class="clear"></div>
				</div>
				<div class="autoLogin">
					
					
				</div>
				<div class="btn-red">
					<input  type="submit" value="登录" id="login-btn">
				</div>
			</form>
		</div>
	</body>
</html>