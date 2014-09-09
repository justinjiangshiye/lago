<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">编辑公告</h3>
<form class="form-horizontal" role="form" method="post" action="<c:url value="/admin/bulletinBoardSave"/>">
	<div class="form-group">
        <label for="inputSummary" class="col-sm-2 control-label">公告</label>
        <div class="col-sm-10">
            <input id="inputSummary" name="Summary" type="text" class="form-control" value="${bulletinBoard.summary}">
            <input type="hidden" name="Id" value="${bulletinBoard.id}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputContent" class="col-sm-2 control-label">公告详情</label>
        <div class="col-sm-10">
            <input id="inputContent" name="Content" type="text" class="form-control" value="${bulletinBoard.content}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputIsPublished" class="col-sm-2 control-label">是否发布</label>
        <div class="col-sm-10">
            <input id="inputIsPublished" name="Ispublished" type="checkbox"
                class="form-control" checked="${bulletinBoard.ispublished}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputOrder" class="col-sm-2 control-label">排序</label>
        <div class="col-sm-10">
            <input id="inputOrder" name="Order" type="text" class="form-control" value="${bulletinBoard.order}">
        </div>
    </div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">保存</button>
		</div>
	</div>
</form>
<%@ include file="../template/admin-tailer.jsp"%>