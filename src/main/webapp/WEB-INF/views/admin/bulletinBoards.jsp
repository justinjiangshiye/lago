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
                        <th class="center">#</th>
                        <th class="center">公告</th>
                        <th class="center">公告详情</th>
                        <th class="center">是否发布</th>
                        <th class="center">排序</th>
                        <th class="center">操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${bulletinBoardList}" var="bulletinBoard" varStatus="status">
                    <tr>
                        <td class="center"><c:out value="${bulletinBoard.id}"></c:out></td>
                        <td><c:out value="${bulletinBoard.summary}"></c:out></td>
                        <td><c:out value="${bulletinBoard.content}"></c:out></td>
                        <td class="center"><c:choose>
                            <c:when test="${bulletinBoard.ispublished==true}">是</c:when>
                            <c:otherwise>否</c:otherwise>
                        </c:choose></td>
                        <td class="center"><c:if
                            test="${status.first==false}">
                            <a class="moveUp" href="javascript:void(0)"
                                action="<c:url value="/admin/bulletinBoardMoveUp/${bulletinBoard.id}" />"><span
                                class="glyphicon glyphicon-arrow-up"></span></a>
                        </c:if>
                        <c:if test="${status.last==false}">
                            <a class="moveDown" href="javascript:void(0)"
                                action="<c:url value="/admin/bulletinBoardMoveDown/${bulletinBoard.id}" />"><span
                                class="glyphicon glyphicon-arrow-down"></span></a>
                        </c:if></td>
                        <td class="center"><a href="<c:url value="/admin/bulletinBoardEdit/${bulletinBoard.id}"/>">编辑</a>&nbsp;
                        <a class="delete" href="javascript:void(0);" action="<c:url value="/admin/bulletinBoardDelete/${bulletinBoard.id}"/>">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table></div>
<%@ include file="../template/admin-tailer.jsp"%>