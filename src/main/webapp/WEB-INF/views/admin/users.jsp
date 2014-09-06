<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">用户管理</h3>
<div>
	<span><a href="<c:url value="/admin/userAdd"></c:url>">增加管理员</a></span>
</div>
<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>用户类型</th>
				<th>用户名</th>
				<th>昵称</th>
				<th>上次登录时间</th>
				<th>注册时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td><c:out value="${user.id}"></c:out></td>
					<td><c:choose>
							<c:when test="${user.type==0}">管理员</c:when>
							<c:when test="${user.type==1}">匿名</c:when>
							<c:when test="${user.type==2}">QQ</c:when>
							<c:otherwise>微博</c:otherwise>
						</c:choose></td>
					<td><c:out value="${user.loginid}"></c:out></td>
					<td><c:out value="${user.nickname}"></c:out></td>
					<td><fmt:formatDate value="${user.lastvisiton}" type="date" pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${user.registeron}" type="date" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="../template/admin-tailer.jsp"%>