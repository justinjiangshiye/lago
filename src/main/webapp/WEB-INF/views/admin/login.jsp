<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="51拉钩后台管理系统">
<meta name="author" content="云顶畅游">
<link rel="icon" href="<c:url value="/images/icon.png" />">

<title>51拉钩后台管理系统</title>

<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/css/jquery.cleditor.css" />" rel="stylesheet">
<link href="<c:url value="/css/admin.css" />" rel="stylesheet">
<script type="text/javascript"
	src="<c:url value="/js/jquery-1.11.1.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/jquery.extends.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/jquery.cleditor.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/global.js" />"></script>
<!--[if lt IE 9]>
      <script src="<c:url value="/js/html5shiv.min.js" /></script>
      <script src="<c:url value="/js/respond.min.js" /></script>
    <![endif]-->
</head>
<body role="document">

	<div class="container" style="width: 290px;">

		<form class="form-signin" action="<c:url value="/admin/doLogin" />"
			method="post" role="form">
			<h2 class="form-signin-heading">登录</h2>
			<input type="text" name="loginid" class="form-control"
				placeholder="用户名"> <br /> <input type="password"
				name="password" class="form-control" placeholder="密码"> <br />
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>
		<c:if test="${loginStatus==false }">
			<br />
			<div class="alert alert-warning" role="alert">${msg}</div>
		</c:if>
	</div>
	<!-- /container -->
</body>
</html>