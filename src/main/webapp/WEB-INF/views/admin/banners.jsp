<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">首页Banner管理</h3>
<div>
	<span><a href="<c:url value="/admin/bannerAdd"></c:url>">增加</a></span>
</div>
<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th class="center">#</th>
				<th class="center">标题</th>
				<th class="center">图片</th>
				<th class="center">链接</th>
				<th class="center">排序</th>
				<th class="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bannerLinkList}" var="bannerLink" varStatus="status">
				<tr>
					<td class="center">${bannerLink.id}</td>
					<td>${bannerLink.text}</td>
					<td class="center"><img
						src="<c:url value="${bannerLink.bannerurl}" />" width="95px"
						height="41px" /></td>
					<td>${bannerLink.contenturl}</td>
					<td class="center"><c:if
							test="${status.first==false}">
							<a class="moveUp" href="javascript:void(0)"
								action="<c:url value="/admin/bannerMoveUp/${bannerLink.id}" />"><span
								class="glyphicon glyphicon-arrow-up"></span></a>
						</c:if>
						<c:if test="${status.last==false}">
							<a class="moveDown" href="javascript:void(0)"
								action="<c:url value="/admin/bannerMoveDown/${bannerLink.id}" />"><span
								class="glyphicon glyphicon-arrow-down"></span></a>
						</c:if></td>
					<td class="center"><a
						href="<c:url value="/admin/bannerEdit/${bannerLink.id}"/>">编辑</a>&nbsp;
						<a class="delete"
						action="<c:url value="/admin/bannerDelete/${bannerLink.id}"/>"
						href="javascript:void(0);">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="../template/admin-tailer.jsp"%>