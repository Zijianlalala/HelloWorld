<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cn.anwuli.bean.User" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>俺屋里</title>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">俺屋里</a>
          </div>
          <ul class="nav navbar-nav navbar-right">
          	<c:set var="username" scope="session" value="${sessionScope.LoginUser.nickname}"/>
          	<c:choose>
          		<c:when test="${username != null}">
          			<li><a href="Info.action?type=1"><span class="glyphicon glyphicon-user"></span> ${sessionScope.LoginUser.nickname }</a></li>
            			<li><a href="Logout.action"><span class="glyphicon glyphicon-log-in"></span> 退出</a></li>
          		</c:when>
          		<c:when test="${username == null}">
          			<li><a href="Login.action"><span class="glyphicon glyphicon-user"></span> 登录</a></li>
            			<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 注册</a></li>
          		</c:when>
          	</c:choose>
          </ul>
        </div>
      </nav>
    <div class="container">
        <h1>每日十词</h1>
        <div class="panel panel-default">
            <div id="word-content" class="panel-heading">
                <h3 class="panel-title"></h3>
            </div>
            <!-- style="background-color:black" -->
            <div id="word-translation" class="panel-body" ></div>
        </div>
        <div class="btn-group btn-group-lg">
            <button id="show-meaning" type="button" class="btn btn-info">
                <span class="glyphicon glyphicon-search"></span>显示
            </button>
            <button id="mark" type="button" class="btn btn-primary">收藏</button>
            <button id="next-word" type="button" class="btn btn-info">下一个</button>
        </div>
    </div>
    <br>
    <div class="container">
        <blockquote>
            I have nothing to offer but blood, toil, tear and sweat.
            <small>Winston Churchill</small>
        </blockquote>
    </div>


	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
    <script>
        var result;
        var user = "<%=((User) session.getAttribute("LoginUser"))!=null?((User) session.getAttribute("LoginUser")).getNickname():null %>";
        var i = 0;
        
        $.getJSON("http://localhost:8080/HelloWorld/WordList.action", function(data){
        result = data;
        showWord();
        });
        /* 显示下一个单词 */
        function showWord() {
            /* 根据本地的单词对象中的是否被收藏的属性来判断是否显示收藏按钮 */
            if(result[i].isCollected == true) {
				/* 隐藏按钮 */
            		disableMark();
            } else {
				enableMark();
            }
            $("#word-content").html(result[i].content);
            $("#word-translation").html(result[i].translation);
            $("#word-translation").attr("style", "background-color: black");
        }
        /* 点击下一个按钮 */
        $("button#next-word").on('click', function(){
      	  	i++;
      	 	i = i%10;
            showWord();
            
        });
        /* 点击显示按钮，显示当前意思 */
        $("button#show-meaning").on('click', function(){
            $("#word-translation").removeAttr("style");
        });
        /* 点击收藏按钮，发送请求，并disabled按钮 */
        $('button#mark').on('click', function(){
            if(user != "null") {
	            	$.ajax({
	                    type: 'POST',
	                    url: 'http://localhost:8080/HelloWorld/addCollection.action',
	                    data: {id : result[i].id},
	                    success: function() {
	    					disableMark();
	    					result[i].isCollected = true;	
	                    }
	                });
            } else {
				alert("登录后可以使用收藏功能");
            }
        });
        /* 重置收藏按钮 */
        function enableMark() {
        		$('button#mark').removeAttr('disabled');
           	 $('button#mark').html('收藏');
            }
        /* 禁止收藏按钮 */
        function disableMark(){
            $('button#mark').attr('disabled', 'true');
            $('button#mark').html('已收藏');
        }
    </script>
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>