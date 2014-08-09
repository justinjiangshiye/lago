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
	<!-- header -->
	<div class="header">
		<div class="container">
			<h3 class="white">51Lago后台运维系统</h3>
		</div>
	</div>
	<!-- body -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="<c:url value="/admin/" />">概览</a></li>
					<li><a href="<c:url value="/admin/banner/" />">首页Banner设置</a></li>
					<li><a href="<c:url value="/admin/articles" />">文章管理</a></li>
					<li><a href="<c:url value="/admin/indexBuild" />">索引管理</a></li>
					<li><a href="<c:url value="/admin/friendLinks" />">友情链接管理</a></li>
					<li><a href="<c:url value="/admin/about" />">关于我们</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">