<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="<c:choose><c:when test="${article!=null}">${article.title}-51拉钩-轻松培养孩子良好的行为习惯</c:when><c:otherwise>51拉钩-轻松培养孩子良好的行为习惯</c:otherwise></c:choose>">
<meta name="author" content="云顶畅游">
<link rel="icon" href="<c:url value="/images/icon.png" />">
<title><c:choose>
		<c:when test="${article!=null}">${article.title}-51拉钩-轻松培养孩子良好的行为习惯</c:when>
		<c:otherwise>51拉钩-轻松培养孩子良好的行为习惯</c:otherwise>
	</c:choose></title>
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/css/custom.css" />" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="<c:url value="/js/html5shiv.min.js" />"></script>
      <script src="<c:url value="/js/respond.min.js" />"></script>
<![endif]-->
<script type="text/javascript"
	src="<c:url value="/js/jquery-1.11.1.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/jquery.extends.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/jquery.validate.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/additional-methods.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/global.js" />"></script>
</head>
<body role="document">
	<div class="weixin">
		<h3 class="article-title">${article.title}</h3>
		<div class="article-title-comment">
			<span><fmt:formatDate value="${article.publishdate}"
					type="date" pattern="yyyy-MM-dd" /></span> <span>${article.category}</span>
			<span>阅读次数:&nbsp;${articleReadTime}</span> <span>评论数：&nbsp;${articleCommentsCount}</span>
		</div>
		<div>${article.content}</div>
		<hr />
		<h4>
			欢迎关注<img src="<c:url value="/images/icon.png" />" />51拉钩（微信号lago51）！
		</h4>
		<p>51拉钩致力于全面促进家庭建设，增进家庭情感关怀，传播科学教养新知，弘扬有品质的生活态度。
		我们设置了“父母学堂、我爱我家、守护成长、亲子阅读、乐享生活”5个栏目，为读者们提供有深度、
		有价值、最干货的文章，每周一、三、五更新。</p>
		<c:forEach items="${appDownloadList}" var="appDownload">
			<hr />
			<div class="row">
				<div class="col-xs-12">${appDownload.appname}</div>
				<div class="col-xs-12">&nbsp;</div>
				<div class="col-xs-2">安卓版：</div>
				<div class="col-xs-4">
					<img src="<c:url value="${appDownload.androidqrcodeurl}" />" />
				</div>
				<div class="col-xs-2">苹果版：</div>
				<div class="col-xs-4">
					<img src="<c:url value="${appDownload.iosqrcodeurl}" />" />
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>