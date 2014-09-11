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
				<th>#</th>
				<th>标题</th>
				<th>图片</th>
				<th>链接</th>
				<th>排序</th>
                <th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bannerLinkList}" var="bannerLink">
				<tr>
					<td>${bannerLink.id}</td>
					<td>${bannerLink.text}</td>
					<td><img src="<c:url value="${bannerLink.bannerurl}" />" width="95px" height="41px" /></td>
					<td>${bannerLink.contenturl}</td>
					<td>${bannerLink.order}</td>
					<td>
					    <a href="<c:url value="/admin/bannerEdit/${bannerLink.id}"/>">编辑</a>&nbsp;
						<a class="delete" action="<c:url value="/admin/bannerDelete/${bannerLink.id}"/>" href="javascript:void(0);">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="../template/admin-tailer.jsp"%>