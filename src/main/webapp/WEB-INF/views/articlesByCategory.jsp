<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="template/header.jsp"%>
<div class="row row-offcanvas row-offcanvas-right">
	<div class="col-xs-10 category">
		<c:forEach items="${articleList}" var="article">
			<div class="col-xs-6">
				<div class="thumbnail">
					<img src="<c:url value="${article.bannerurl}" />" alt="" />
					<div class="caption">
						<h5>${article.title}</h5>
						<p>${article.abstractcontent}</p>
						<p class="text-right">
							<a href="<c:url value="/article/${article.slugsurl}" />"
								class="btn btn-primary" role="button">点击</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<%@ include file="template/right.jsp"%>
</div>
<%@ include file="template/tailer.jsp"%>