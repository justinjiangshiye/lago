<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="<c:url value="/images/icon.png" />">

<title>51Lago</title>

<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/css/custom.css" />" rel="stylesheet">
<script type="text/javascript"
	src="<c:url value="/js/jquery-1.11.1.min.js" />"></script>
<script type="text/javascript"
    src="<c:url value="/js/jquery.extends.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/global.js" />"></script>
<!--[if lt IE 9]>
      <script src="<c:url value="/js/html5shiv.min.js" /></script>
      <script src="<c:url value="/js/respond.min.js" /></script>
    <![endif]-->
</head>
<body role="document">
	<!-- Static navbar -->
	<div class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<img class="navbar-brand"
					src="<c:url value="/images/top-left-logo.png" />" alt="" />
			</div>
			<div class="navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value="/user/weibologin" />" ><img
							src="<c:url value="/images/weibo.png" />" alt="" />&nbsp;微博帐号登录</a></li>
					<li><a href="<c:url value="/user/qqlogin" />" ><img
							src="<c:url value="/images/qq.png" />" alt="" />&nbsp;QQ帐号登录</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<!-- header -->
	<div class="header">
		<div class="container">
			<div class="logo">
				<a href="http://www.51lago.com/"><img
					src="<c:url value="/images/logo.png" />" alt="" /></a>
				<div class="navbar-right search">
					<input type="text" id="inputSearch" name="textSearch"
						placeholder="请输入关键字搜索" />
					<button id="btnSearch" class="btn icon-search"
						action="<c:url value="/search/" />">搜索</button>
				</div>
			</div>
			<ul class="nav nav-pills pull-right">
				<li <c:if test="${activeMenuItemId==1}"> class="active"</c:if>><a
					href="<c:url value="/" />">首页</a></li>
				<li <c:if test="${activeMenuItemId==2}"> class="active"</c:if>><a
					href="#">51拉钩</a></li>
				<li <c:if test="${activeMenuItemId==3}"> class="active"</c:if>><a
					href="#">51听听</a></li>
				<li <c:if test="${activeMenuItemId==4}"> class="active"</c:if>><a
					href="<c:url value="/category/parent-school" />">父母学堂</a></li>
				<li <c:if test="${activeMenuItemId==5}"> class="active"</c:if>><a
					href="<c:url value="/category/grow-up" />">守护成长</a></li>
				<li <c:if test="${activeMenuItemId==6}"> class="active"</c:if>><a
					href="<c:url value="/category/love-family" />">我爱我家</a></li>
				<li <c:if test="${activeMenuItemId==7}"> class="active"</c:if>><a
					href="<c:url value="/category/reading" />">亲子阅读</a></li>
				<li <c:if test="${activeMenuItemId==8}"> class="active"</c:if>><a
					href="<c:url value="/about" />">关于我们</a></li>
			</ul>
		</div>
	</div>
	<div class="bulletin">
		<div class="container">
			<div class="col-md-1 no-padding">站点公告：</div>
			<div class="col-md-11 marquee no-padding">
			    <ul>
                <c:forEach items="${bulletinBoardList}" var="bulletinBoardItem">
                    <li><a href="" target="_blank">${bulletinBoardItem.summary}</a></li>
                </c:forEach>
			    </ul>
			</div>
		</div>
	</div>
	<!-- body -->
	<div class="body">
		<div class="container">