<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的收藏</title>
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
			<div class="panel-heading">我的收藏</div>
			<table class="table">
				<tbody>
					<c:forEach items="${requestScope.collection }" var="item">
					<tr>
						<td>${item.content }</td>
						<td>${item.translation }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
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