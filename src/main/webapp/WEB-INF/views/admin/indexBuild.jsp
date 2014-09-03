<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">索引管理</h3>
<div>
	新建、更新或删除文章后，请点击下面重建索引按钮，重建索引，否则，全文搜索可能失效或导致搜索结果有误。
	<br /><br />
</div>
<div class="table-responsive">
<form class="form-horizontal" role="form" method="post" action="<c:url value="/admin/indexBuildRun"/>">
    <div class="form-group">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-default">重建索引</button>
        </div>
    </div>
</form>
</div>
<%@ include file="../template/admin-tailer.jsp"%>