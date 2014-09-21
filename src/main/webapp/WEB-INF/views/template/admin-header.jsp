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
    src="<c:url value="/js/jquery.validate.min.js" />"></script>
<script type="text/javascript"
    src="<c:url value="/js/additional-methods.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/jquery.cleditor.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/admin.js" />"></script>
<!--[if lt IE 9]>
      <script src="<c:url value="/js/html5shiv.min.js" /></script>
      <script src="<c:url value="/js/respond.min.js" /></script>
    <![endif]-->
</head>
<body role="document">
	<!-- header -->
	<div class="header">
		<h4 class="headtitle">51拉钩后台运维系统 v1.0</h4>
	</div>
	<!-- body -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li <c:if test="${activeMenuItemId==100}"> class="active"</c:if>><a
						href="<c:url value="/admin/" />"><span
							class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;概览</a> <c:if
							test="${activeMenuItemId==100}">
							<span class="selected"></span>
						</c:if></li>
					<li <c:if test="${activeMenuItemId==101}"> class="active"</c:if>><a
						href="<c:url value="/admin/bulletinBoards/" />"><span
							class="glyphicon glyphicon-comment"></span>&nbsp;&nbsp;公告栏管理</a> <c:if
							test="${activeMenuItemId==101}">
							<span class="selected"></span>
						</c:if></li>
					<li <c:if test="${activeMenuItemId==102}"> class="active"</c:if>><a
						href="<c:url value="/admin/banner/" />"><span
							class="glyphicon glyphicon-picture"></span>&nbsp;&nbsp;首页Banner管理</a>
						<c:if test="${activeMenuItemId==102}">
							<span class="selected"></span>
						</c:if></li>
					<li <c:if test="${activeMenuItemId==103}"> class="active"</c:if>><a
						href="<c:url value="/admin/staticPage/51lago" />"><span
							class="glyphicon glyphicon-pushpin"></span>&nbsp;&nbsp;展示页管理</a> <c:if
							test="${activeMenuItemId==103}">
							<span class="selected"></span>
						</c:if></li>
					<li><a href="javascript:(0)"><span
							class="glyphicon glyphicon-book"></span>&nbsp;&nbsp;文章管理&nbsp;&nbsp;<span
							class="glyphicon glyphicon-chevron-down open"></span></a></li>
					<li <c:if test="${activeMenuItemId==104}"> class="active"</c:if>><a
						href="<c:url value="/admin/category/parent-school" />">&nbsp;&nbsp;<span
							class="glyphicon glyphicon-chevron-right"></span>&nbsp;&nbsp;父母学堂
					</a> <c:if test="${activeMenuItemId==104}">
							<span class="selected"></span>
						</c:if></li>
					<li <c:if test="${activeMenuItemId==105}"> class="active"</c:if>><a
						href="<c:url value="/admin/category/grow-up" />">&nbsp;&nbsp;<span
							class="glyphicon glyphicon-chevron-right"></span>&nbsp;&nbsp;守护成长
					</a> <c:if test="${activeMenuItemId==105}">
							<span class="selected"></span>
						</c:if></li>
					<li <c:if test="${activeMenuItemId==106}"> class="active"</c:if>><a
						href="<c:url value="/admin/category/love-family" />">&nbsp;&nbsp;<span
							class="glyphicon glyphicon-chevron-right"></span>&nbsp;&nbsp;我爱我家
					</a> <c:if test="${activeMenuItemId==106}">
							<span class="selected"></span>
						</c:if></li>
					<li <c:if test="${activeMenuItemId==107}"> class="active"</c:if>><a
						href="<c:url value="/admin/category/reading" />">&nbsp;&nbsp;<span
							class="glyphicon glyphicon-chevron-right"></span>&nbsp;&nbsp;亲子阅读
					</a> <c:if test="${activeMenuItemId==107}">
							<span class="selected"></span>
						</c:if></li>
					<li <c:if test="${activeMenuItemId==108}"> class="active"</c:if>><a
						href="<c:url value="/admin/indexBuild" />"><span
							class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;索引管理</a> <c:if
							test="${activeMenuItemId==108}">
							<span class="selected"></span>
						</c:if></li>
					<li <c:if test="${activeMenuItemId==109}"> class="active"</c:if>><a
						href="<c:url value="/admin/friendLinks" />"><span
							class="glyphicon glyphicon-link"></span>&nbsp;&nbsp;友情链接管理</a> <c:if
							test="${activeMenuItemId==109}">
							<span class="selected"></span>
						</c:if></li>
					<li <c:if test="${activeMenuItemId==110}"> class="active"</c:if>><a
						href="<c:url value="/admin/users" />"><span
							class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;用户管理</a> <c:if
							test="${activeMenuItemId==110}">
							<span class="selected"></span>
						</c:if></li>
					<li><a href="<c:url value="/admin/logout" />"><span
                            class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;注销</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">