<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="template/header.jsp"%>

<div class="row row-offcanvas row-offcanvas-right">
	<div class="col-xs-10">
		<div>${staticPage.content}</div>
	</div>
	<%@ include file="template/right.jsp"%>
</div>
<%@ include file="template/tailer.jsp"%>