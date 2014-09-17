<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">编辑文章</h3>
<form id="form" class="form-horizontal" role="form" method="post"
	action="<c:url value="/admin/articleSave"/>">
	<div class="form-group">
		<label for="selectCategory" class="col-sm-2 control-label">栏目</label>
		<div class="col-sm-10">
			<span id="selectCategory">${article.category}</span> <input
				type="hidden" name="Id" value="${article.id}"> <input
				type="hidden" name="Category" value="${article.category}">
		</div>
	</div>
	<div class="form-group">
		<label for="inputTitle" class="col-sm-2 control-label">标题</label>
		<div class="col-sm-4">
			<input id="inputTitle" name="Title" type="text" class="form-control"
				value="${article.title}">
		</div>
		<label for="inputSlugsUrl" class="col-sm-2 control-label">友好链接标识</label>
		<div class="col-sm-4">
			<span>${article.slugsurl}</span> <input id="inputSlugsUrl"
				name="Slugsurl" type="hidden" value="${article.slugsurl}">
		</div>
	</div>
	<div class="form-group">
		<label for="inputBannerUrl" class="col-sm-2 control-label">Banner图</label>
		<div class="col-sm-10">
			<input id="inputBannerUrl" name="Bannerurl" type="text"
				class="form-control" value="${article.bannerurl}">
		</div>
	</div>
	<div class="form-group">
		<label for="inputAbstractContent" class="col-sm-2 control-label">摘要</label>
		<div class="col-sm-10">
			<textarea id="inputAbstractContent" name="Abstractcontent"
				class="form-control" rows="3">${article.abstractcontent}</textarea>
		</div>
	</div>
	<div class="form-group">
		<label for="inputIsDisplayOnHome" class="col-sm-2 control-label">是否首页显示</label>
		<div class="col-sm-4">
			<input id="inputIsDisplayOnHome" name="Isdisplayonhome"
				type="checkbox"
				<c:if test="${article.isdisplayonhome==true}">checked="checked"</c:if>>
		</div>
		<label for="inputIsLockTop" class="col-sm-2 control-label">是否置顶</label>
		<div class="col-sm-4">
			<input id="inputIsLockTop" name="Islocktop" type="checkbox"
				<c:if test="${article.islocktop==true}">checked="checked"</c:if>>
		</div>
	</div>
	<div class="form-group">
		<label for="inputOrder" class="col-sm-2 control-label">排序</label>
		<div class="col-sm-4">
			<input id="inputOrder" name="Order" type="text" class="form-control"
				value="${article.order}">
		</div>
		<label for="inputIsPublished" class="col-sm-2 control-label">是否发布</label>
		<div class="col-sm-4">
			<input id="inputIsPublished" name="Ispublished" type="checkbox"
				<c:if test="${article.ispublished==true}">checked="checked"</c:if>>
		</div>
	</div>
	<div class="form-group">
		<label for="inputKeywords" class="col-sm-2 control-label">关键字</label>
		<div class="col-sm-10">
			<input id="inputKeywords" name="Keywords" type="text"
				class="form-control" value="${article.keywords}">
		</div>
	</div>
	<div class="form-group">
		<label for="inputContent" class="col-sm-2 control-label">内容</label>
		<div class="col-sm-10">
			<textarea id="inputContent" name="Content" class="form-control"
				rows="10">${article.content}</textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">保存</button>
		</div>
	</div>
</form>
<script type="text/javascript">
	$(document).ready(function() {
		$("#inputContent").cleditor();
		$('#form').validate({
			rules : {
				Title : {
					required : true,
					minlength : 2,
					maxlength : 50
				},
				Bannerurl : {
					required : true
				},
				Abstractcontent : {
					required : true,
					minlength : 30,
					maxlength : 100
				},
				Order : {
					required : true
				},
				Keywords : {
					required : true
				},
				Content : {
					required : true
				}
			},
			messages : {
				Title : {
					required : "此项不能为空！",
					minlength : "字符长度不能少于2个字符",
					maxlength : "字符长度不能少多于50个字符"
				},
				Bannerurl : {
					required : "此项不能为空！"
				},
				Abstractcontent : {
					required : "此项不能为空！",
					minlength : "字符长度不能少于30个字符",
					maxlength : "字符长度不能少多于100个字符"
				},
				Order : {
					required : "此项不能为空！"
				},
				Keywords : {
					required : "此项不能为空！"
				},
				Content : {
					required : "此项不能为空！"
				}
			}
		});
	});
</script>
<%@ include file="../template/admin-tailer.jsp"%>