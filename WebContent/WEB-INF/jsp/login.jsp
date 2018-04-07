<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">俺屋里</a>
          </div>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
          </ul>
        </div>
      </nav>
	<div class="container">
		<h1>俺屋里 <small>anwuli.cn</small></h1>
		<form action="Login.action" method="post">
			<div class="form-group">
				<label>用户名</label> 
				<input name="username" type="text" class="form-control" placeholder="Enter username">
			</div>
			<div class="form-group">
				<label>密码</label> 
				<input name="password" type="password" class="form-control" placeholder="Password">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div> 
	<br>
    <div class="container">
        <blockquote>
            I have nothing to offer but blood, toil, tear and sweat.
            <small>Winston Churchill</small>
        </blockquote>
    </div>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>