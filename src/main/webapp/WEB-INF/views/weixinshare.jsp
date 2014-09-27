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
<meta name="description" content="51拉钩-轻松培养孩子良好的行为习惯">
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
</head>
<body role="document">
    <div class="weixin">
        <h4>
            分享到微信朋友圈
        </h4>
        <hr />
        <p class="center">
            <img src="<c:url value="/files/" />${article.slugsurl}.png">
        </p>
        <p>打开微信，点击“发现”，使用 “扫一扫” 即可将网页分享到我的朋友圈。</p>
    </div>
</body>
</html>