<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="template/header.jsp"%>
<div class="row row-offcanvas row-offcanvas-right">
	<div class="col-xs-10">
		<h3>${article.title}</h3>
		<div>
			<span><fmt:formatDate value="${article.publishdate}" type="date" pattern="yyyy-MM-dd" /></span>
			<span>${article.category}</span>
			<span>评论&nbsp;TODO</span>
		</div>
		<div>${article.content}</div>
		<div>分享到：...</div>
		<div>
			<div></div>
		</div>
	</div>
	<%@ include file="template/right.jsp"%>
</div>
<%@ include file="template/tailer.jsp"%>