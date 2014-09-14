<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-xs-2">
	<c:forEach items="${appDownloadList}" var="appDownload">
		<div class="panel panel-default appDownload">
			<div class="panel-heading">${appDownload.appname}</div>
			<div class="panel-body">
				<p>
					<img src="<c:url value="${appDownload.androidqrcodeurl}" />" /><br />
					<c:choose>
						<c:when test="${appDownload.isandroidapppublished==true}">
							<a href="<c:url value="${appDownload.androiddownloadurl }" />"
								class="androidDownload" target="_blank">&nbsp;</a>
						</c:when>
						<c:otherwise>
							<a href="alert('敬请期待！');" class="androidDownload">&nbsp;</a>
						</c:otherwise>
					</c:choose>
				</p>
				<hr />
				<p>
					<img src="<c:url value="${appDownload.iosqrcodeurl}" />" /><br />
					<c:choose>
						<c:when test="${appDownload.isiosapppublished==true}">
							<a href="<c:url value="${appDownload.iosdownloadurl }" />"
								class="iosDownload" target="_blank">&nbsp;</a>
						</c:when>
						<c:otherwise>
							<a href="alert('敬请期待！');" class="androidDownload">&nbsp;</a>
						</c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
	</c:forEach>
	<div class="panel panel-default">
		<div class="panel-heading">
			热读文章&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="<c:url value="/article/hotreading" />">更多</a>
		</div>
		<div class="panel-body">
			<c:forEach items="${hotReadArticleList}" var="article">
				<p>
					<a href="<c:url value="/article/${article.slugsurl}" />">${article.title}</a>
			</c:forEach>
		</div>
	</div>
</div>