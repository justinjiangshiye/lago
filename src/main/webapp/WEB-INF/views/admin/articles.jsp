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
				<th>#</th>
				<th>栏目</th>
				<th>标题</th>
				<th>是否显示首页</th>
				<th>是否置顶</th>
				<th>排序</th>
				<th>是否发布</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${articleList}" var="article">
				<tr>
					<td><c:out value="${article.id}"></c:out></td>
					<td><c:out value="${article.category}"></c:out></td>
					<td><c:out value="${article.title}"></c:out></td>
					<td><c:choose>
							<c:when test="${article.isdisplayonhome==true}">是</c:when>
							<c:otherwise>否</c:otherwise>
						</c:choose></td>
					<td><c:choose>
                            <c:when test="${article.islocktop==true}">是</c:when>
                            <c:otherwise>否</c:otherwise>
                        </c:choose></td>
					<td><c:out value="${article.order}"></c:out></td>
					<td><c:choose>
                            <c:when test="${article.ispublished==true}">是</c:when>
                            <c:otherwise>否</c:otherwise>
                        </c:choose></td>
					<td><a
						href="<c:url value="/admin/articleEdit/${article.id}"/>">编辑</a>&nbsp;
						<a class="delete" href="javascript:void(0);" action="<c:url value="/admin/articleDelete/${article.id}"/>">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="../template/admin-tailer.jsp"%>