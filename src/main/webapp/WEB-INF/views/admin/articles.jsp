<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp" %>
        <h3 class="sub-header">文章列表</h3>
        <div>
            <span><a href="<c:url value="/admin/articleAdd"></c:url>">增加</a></span>
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
						<td><c:out value="${article.isdisplayonhome}"></c:out></td>
						<td><c:out value="${article.islocktop}"></c:out></td>
						<td><c:out value="${article.order}"></c:out></td>
						<td><c:out value="${article.ispublished}"></c:out></td>
						<td><a href="<c:url value="/admin/articleEdit/${article.id}"/>">编辑</a>&nbsp;
						<a href="<c:url value="/admin/articleDelete/${article.id}"/>">删除</a>
						</td>
	                </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
<%@ include file="../template/admin-tailer.jsp" %>