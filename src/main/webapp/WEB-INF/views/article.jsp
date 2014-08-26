<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="template/header.jsp"%>
<div class="row row-offcanvas row-offcanvas-right">
	<div class="col-xs-10">
		<h3 class="article-title">${article.title}</h3>
		<div>
			<span><fmt:formatDate value="${article.publishdate}" type="date" pattern="yyyy-MM-dd" /></span>
			<span>${article.category}</span>
			<span>评论&nbsp;TODO</span>
		</div>
		<div>${article.content}</div>
		<div class="article-share">
		    <ul>
		        <li><span>分享到：</span></li>
		        <li><a href="#"><img src="<c:url value="/images/share2weibo.gif" />" />新浪微博</a></li>
		        <li><a href="#"><img src="<c:url value="/images/share2qqspace.gif" />" />QQ空间</a></li>
		        <li><a href="#"><img src="<c:url value="/images/share2qqweibo.gif" />" />QQ微博</a></li>
		        <li><a href="#"><img src="<c:url value="/images/share2weixin.gif" />" />微信</a></li>
		    </ul>
		</div>
		<div>
			<form role="form">
			  <div class="form-group">
			    <label for="inputNickName">昵称</label>
			    <input type="text" class="form-control" id="inputNickName" placeholder="请输入昵称">
			  </div>
			  <div class="form-group">
			    <label for="inputComments">评论</label>
			    <textarea class="form-control" rows="3" id="inputComments"></textarea>
			  </div>
			  <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
	<%@ include file="template/right.jsp"%>
</div>
<%@ include file="template/tailer.jsp"%>