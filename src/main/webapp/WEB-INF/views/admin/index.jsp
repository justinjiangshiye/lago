<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp" %>
        <h3 class="sub-header">概述</h3>
        <div>
            <h4>累计用户访问次数：${visitCount}</h4>
            <h4>累计文章阅读次数：${articleReadingCount}</h4>
            <h4>累计文章分享次数：<a target="_blank" href="http://www.jiathis.com/analytics/report/">单击</a></h4>
            <h4>累计文章评论次数：${articleCommentsCount}</h4>
        </div>
        <div class="table-responsive">
    </div>
<%@ include file="../template/admin-tailer.jsp" %>