<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">新增文章</h3>
<form class="form-horizontal" role="form" method="post" action="<c:url value="/admin/articleSave"/>">
	<div class="form-group">
		<label for="selectCategory" class="col-sm-2 control-label">栏目</label>
		<div class="col-sm-10">
			<input type="hidden" name="Category" value="${category}" />
			<span>${category}</span>
		</div>
	</div>
	<div class="form-group">
		<label for="inputTitle" class="col-sm-2 control-label">标题</label>
		<div class="col-sm-4">
			<input id="inputTitle" name="Title" type="text" class="form-control">
		</div>
		<label for="inputSlugsUrl" class="col-sm-2 control-label">友好链接标识</label>
		<div class="col-sm-4">
			<input id="inputSlugsUrl" name="Slugsurl" type="text"
				class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="inputBannerUrl" class="col-sm-2 control-label">Banner图</label>
		<div class="col-sm-10">
			<input id="inputBannerUrl" name="Bannerurl" type="text"
				class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="inputAbstractContent" class="col-sm-2 control-label">摘要</label>
		<div class="col-sm-10">
			<textarea id="inputAbstractContent" name="Abstractcontent"
				class="form-control" rows="3"></textarea>
		</div>
	</div>
	<div class="form-group">
		<label for="inputIsDisplayOnHome" class="col-sm-2 control-label">是否首页显示</label>
		<div class="col-sm-4">
			<input id="inputIsDisplayOnHome" name="Isdisplayonhome"
				type="checkbox" class="form-control">
		</div>
		<label for="inputIsLockTop" class="col-sm-2 control-label">是否置顶</label>
		<div class="col-sm-4">
			<input id="inputIsLockTop" name="Islocktop" type="checkbox"
				class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="inputOrder" class="col-sm-2 control-label">排序</label>
		<div class="col-sm-4">
			<input id="inputOrder" name="Order" type="text" class="form-control">
		</div>
		<label for="inputIsPublished" class="col-sm-2 control-label">是否发布</label>
		<div class="col-sm-4">
			<input id="inputIsPublished" name="Ispublished" type="checkbox"
				class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="inputKeywords" class="col-sm-2 control-label">关键字</label>
		<div class="col-sm-10">
			<input id="inputKeywords" name="Keywords" type="text"
				class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="inputContent" class="col-sm-2 control-label">内容</label>
		<div class="col-sm-10">
			<textarea id="inputContent" name="Content" class="form-control"
				rows="10"></textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">保存</button>
		</div>
	</div>
</form>
<script type="text/javascript">
	        $(document).ready(function () { 
	        	   $("#inputContent").cleditor(); 
	        });
        </script>
<%@ include file="../template/admin-tailer.jsp"%>