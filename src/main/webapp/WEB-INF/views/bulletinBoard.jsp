<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="template/header.jsp"%>
<div class="row row-offcanvas row-offcanvas-right">
	<div class="col-xs-10">
		<h3 class="article-title">${bulletinBoard.summary}</h3>
		<div class="article-title-comment">
			公告时间：<span><fmt:formatDate
					value="${bulletinBoard.publishdate}" type="date"
					pattern="yyyy-MM-dd" /></span>
		</div>
		<div>${bulletinBoard.content}</div>
	</div>
	<%@ include file="template/right.jsp"%>
</div>
<%@ include file="template/tailer.jsp"%>