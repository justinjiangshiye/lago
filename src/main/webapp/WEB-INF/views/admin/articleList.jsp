<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp" %>
        <h2 class="sub-header">文章列表</h2>
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
	                    <th>#</th>
	                    <th>栏目</th>
	                    <th>标题</th>
	                    <th>是否显示首页</th>
	                    <th>是否置顶</th>
	                    <th>顺序</th>
	                    <th>是否发布</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${articleList}" var="article">
	                <tr>
						<td><c:out value="${article.id}"></c:out></td>
						<td><c:out value="${article.category}"></c:out></td>
						<td><c:out value="${article.title}"></c:out></td>
						<td><c:out value="${article.isdisplayonhome}"></c:out></td>
						<td><c:out value="${article.islocktop}"></c:out></td>
						<td><c:out value="${article.order}"></c:out></td>
						<td><c:out value="${article.ispublished}"></c:out></td>
	                </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
<%@ include file="../template/admin-tailer.jsp" %>