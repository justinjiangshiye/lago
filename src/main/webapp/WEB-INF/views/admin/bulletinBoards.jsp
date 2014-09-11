<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">公告管理</h3>
<div>
	<span><a href="<c:url value="/admin/bulletinBoardAdd"></c:url>">增加</a></span>
</div>
<div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>公告</th>
                        <th>公告详情</th>
                        <th>是否发布</th>
                        <th>排序</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${bulletinBoardList}" var="bulletinBoard">
                    <tr>
                        <td><c:out value="${bulletinBoard.id}"></c:out></td>
                        <td><c:out value="${bulletinBoard.summary}"></c:out></td>
                        <td><c:out value="${bulletinBoard.content}"></c:out></td>
                        <td><c:choose>
                            <c:when test="${bulletinBoard.ispublished==true}">是</c:when>
                            <c:otherwise>否</c:otherwise>
                        </c:choose></td>
                        <td><c:out value="${bulletinBoard.order}"></c:out></td>
                        <td><a href="<c:url value="/admin/bulletinBoardEdit/${bulletinBoard.id}"/>">编辑</a>&nbsp;
                        <a class="delete" href="javascript:void(0);" action="<c:url value="/admin/bulletinBoardDelete/${bulletinBoard.id}"/>">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table></div>
<%@ include file="../template/admin-tailer.jsp"%>