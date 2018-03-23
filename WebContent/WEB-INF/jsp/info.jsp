<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home">俺屋里</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span>
					${sessionScope.LoginUser.nickname }</a></li>
			<li><a href="Logout.action"><span class="glyphicon glyphicon-log-in"></span>
					退出</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">个人中心</div>
			<table class="table">
				<tbody>
					<tr>
						<td>用户名</td>
						<td>${sessionScope.LoginUser.username }</td>
					</tr>
					<tr>
						<td>昵称</td>
						<td>${sessionScope.LoginUser.nickname }</td>
					</tr>
					<tr>
						<td>我的收藏</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<a href="Info.action?type=2" class="btn btn-primary">修改信息</a>
	</div>
	<br>
	<div class="container">
		<blockquote>
			I have nothing to offer but blood, toil, tear and sweat. <small>Winston
				Churchill</small>
		</blockquote>
	</div>
	<!-- 修改按钮 -->
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>