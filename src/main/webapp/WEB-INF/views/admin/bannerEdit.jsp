<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">新增Banner</h3>
<form class="form-horizontal" role="form" method="post"
	action="<c:url value="/admin/bannerSave"/>">
	<div class="form-group">
		<label for="inputText" class="col-sm-2 control-label">标题</label>
		<div class="col-sm-10">
			<input id="inputText" name="Text" type="text" class="form-control" value="${bannerLink.text}">
			<input type="hidden" name="Id" value="${bannerLink.id}">
		</div>
	</div>
	<div class="form-group">
		<label for="inputBannerUrl" class="col-sm-2 control-label">图片</label>
		<div class="col-sm-10">
			<input id="inputBannerUrl" name="Bannerurl" type="hidden"
				class="form-control" value="${bannerLink.bannerurl}">
			<img id="imgBanner" src="<c:url value="${bannerLink.bannerurl}" />" width="100%" />
			<iframe src="<c:url value="/admin/uploadFile" />" frameborder="0" scrolling="no" width="700px" height="40px"></iframe>
		</div>
	</div>
	<div class="form-group">
		<label for="inputContentUrl" class="col-sm-2 control-label">链接</label>
		<div class="col-sm-10">
			<input id="inputContentUrl" name="Contenturl" type="text"
				class="form-control" value="${bannerLink.contenturl}">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
            <a href="<c:url value="/admin/banner" />" class="btn btn-default">返回</a>
            <button type="submit" class="btn btn-primary">保存</button>
		</div>
	</div>
</form>
<script type="text/javascript">
    function fileUploaded(url) {
    	$("#inputBannerUrl").val(url);
    	$("#imgBanner").attr("src", url);
    }
</script>
<%@ include file="../template/admin-tailer.jsp"%>