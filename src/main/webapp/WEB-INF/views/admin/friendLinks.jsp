<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp" %>
        <h3 class="sub-header">友情链接管理</h3>
        <div>
            <span><a href="<c:url value="/admin/friendLinkAdd"></c:url>">增加</a></span>
        </div>
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
	                    <th>#</th>
	                    <th>网站名称</th>
	                    <th>网站链接</th>
	                    <th>图标</th>
	                    <th>排序</th>
	                    <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${friendLinkList}" var="friendLink">
	                <tr>
						<td><c:out value="${friendLink.id}"></c:out></td>
						<td><c:out value="${friendLink.websitename}"></c:out></td>
						<td><c:out value="${friendLink.websiteurl}"></c:out></td>
						<td><c:out value="${friendLink.logourl}"></c:out></td>
						<td><c:out value="${friendLink.order}"></c:out></td>
						<td><a href="<c:url value="/admin/friendLinkEdit/${friendLink.id}"/>">编辑</a>&nbsp;
						<a class="delete" href="javascript:void(0);" action="<c:url value="/admin/friendLinkDelete/${friendLink.id}"/>">删除</a>
						</td>
	                </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
<%@ include file="../template/admin-tailer.jsp" %>