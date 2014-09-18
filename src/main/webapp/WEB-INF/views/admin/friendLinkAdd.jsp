<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">新增友情链接</h3>
<form class="form-horizontal" role="form" method="post" action="<c:url value="/admin/friendLinkSave"/>">
	<div class="form-group">
		<label for="inputWebsitename" class="col-sm-2 control-label">网站名称</label>
		<div class="col-sm-10">
			<input id="inputWebsitename" name="Websitename" type="text" class="form-control">
		</div>
	</div>
	<div class="form-group">
        <label for="inputWebsiteurl" class="col-sm-2 control-label">网站链接</label>
        <div class="col-sm-10">
            <input id="inputWebsiteurl" name="Websiteurl" type="text" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label for="inputlogourl" class="col-sm-2 control-label">图标链接</label>
        <div class="col-sm-10">
            <input id="inputlogourl" name="Logourl" type="text" class="form-control">
        </div>
    </div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
            <a href="<c:url value="/admin/friendLinks" />" class="btn btn-default">返回</a>
            <button type="submit" class="btn btn-primary">保存</button>
		</div>
	</div>
</form>
<%@ include file="../template/admin-tailer.jsp"%>