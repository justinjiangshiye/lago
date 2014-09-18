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
	                    <th class="center">#</th>
	                    <th class="center">网站名称</th>
	                    <th class="center">网站链接</th>
	                    <th class="center">图标</th>
	                    <th class="center">排序</th>
	                    <th class="center">操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${friendLinkList}" var="friendLink" varStatus="status">
	                <tr>
						<td class="center"><c:out value="${friendLink.id}"></c:out></td>
						<td><c:out value="${friendLink.websitename}"></c:out></td>
						<td><c:out value="${friendLink.websiteurl}"></c:out></td>
						<td class="center"><c:out value="${friendLink.logourl}"></c:out></td>
						<td class="center"><c:if
                            test="${status.first==false}">
                            <a class="moveUp" href="javascript:void(0)"
                                action="<c:url value="/admin/friendLinkMoveUp/${friendLink.id}" />"><span
                                class="glyphicon glyphicon-arrow-up"></span></a>
                        </c:if>
                        <c:if test="${status.last==false}">
                            <a class="moveDown" href="javascript:void(0)"
                                action="<c:url value="/admin/friendLinkMoveDown/${friendLink.id}" />"><span
                                class="glyphicon glyphicon-arrow-down"></span></a>
                        </c:if></td>
						<td class="center"><a href="<c:url value="/admin/friendLinkEdit/${friendLink.id}"/>">编辑</a>&nbsp;
						<a class="delete" href="javascript:void(0);" action="<c:url value="/admin/friendLinkDelete/${friendLink.id}"/>">删除</a>
						</td>
	                </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
<%@ include file="../template/admin-tailer.jsp" %>