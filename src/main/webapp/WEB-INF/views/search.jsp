<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ include file="template/header.jsp" %>
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>标题</th>
                        <th>栏目</th>
                        <th>内容</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${searchResult}" var="article">
                    <tr>
                        <td>${article.title}</td>
                        <td>${article.category}</td>
                        <td>${article.content}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
<%@ include file="template/tailer.jsp" %>