<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">文章管理-${articleCategoryName}</h3>
<div>
	<span><a
		href="<c:url value="/admin/articleAdd/${articleCategorySlugsUrl}"></c:url>">增加</a></span>
</div>
<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th class="center">#</th>
				<th class="center">栏目</th>
				<th class="center">标题</th>
				<th class="center">是否显示首页</th>
				<th class="center">是否置顶</th>
				<th class="center">排序</th>
				<th class="center">是否发布</th>
				<th class="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${articleList}" var="article" varStatus="status">
				<tr>
					<td class="center"><c:out value="${article.id}"></c:out></td>
					<td><c:out value="${article.category}"></c:out></td>
					<td><c:out value="${article.title}"></c:out></td>
					<td class="center"><c:choose>
							<c:when test="${article.isdisplayonhome==true}">是</c:when>
							<c:otherwise>否</c:otherwise>
						</c:choose></td>
					<td class="center"><c:choose>
							<c:when test="${article.islocktop==true}">是</c:when>
							<c:otherwise>否</c:otherwise>
						</c:choose></td>
					<td class="center"><c:if test="${status.first==false}">
							<a class="moveUp" href="javascript:void(0)"	action="<c:url value="/admin/articleMoveUp/${article.id}" />"><span
								class="glyphicon glyphicon-arrow-up"></span></a>
						</c:if><c:if test="${status.last==false}">
							<a class="moveDown" href="javascript:void(0)" action="<c:url value="/admin/articleMoveDown/${article.id}" />"><span
								class="glyphicon glyphicon-arrow-down"></span></a>
						</c:if></td>
					<td class="center"><c:choose>
							<c:when test="${article.ispublished==true}">是</c:when>
							<c:otherwise>否</c:otherwise>
						</c:choose></td>
					<td class="center"><a
						href="<c:url value="/admin/articleEdit/${article.id}"/>">编辑</a>&nbsp;
						<a class="delete" href="javascript:void(0);" action="<c:url value="/admin/articleDelete/${article.id}"/>">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="../template/admin-tailer.jsp"%>