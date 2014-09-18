<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">新增友情链接</h3>
<form id="form" class="form-horizontal" role="form" method="post"
	action="<c:url value="/admin/bulletinBoardSave"/>">
	<div class="form-group">
		<label for="inputSummary" class="col-sm-2 control-label">公告</label>
		<div class="col-sm-10">
			<input id="inputSummary" name="Summary" type="text"
				class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="inputContent" class="col-sm-2 control-label">公告详情</label>
		<div class="col-sm-10">
			<textarea id="inputContent" name="Content" class="form-control"
				rows="20"></textarea>
		</div>
	</div>
	<div class="form-group">
		<label for="inputIsPublished" class="col-sm-2 control-label">是否发布</label>
		<div class="col-sm-10">
			<input id="inputIsPublished" name="Ispublished" type="checkbox">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<a href="<c:url value="/admin/bulletinBoards" />"
				class="btn btn-default">返回</a>
			<button type="submit" class="btn btn-primary">保存</button>
		</div>
	</div>
</form>
<script type="text/javascript">
	$(document).ready(function() {
		$("#inputContent").cleditor({
			height : 200
		});
		$('#form').validate({
			rules : {
				Summary : {
					required : true,
					minlength : 2,
					maxlength : 50
				},
                Content : {
                    required : true,
                    minlength : 2,
                    maxlength : 2000
                }
			},
			messages : {
				Summary : {
					required : "此项不能为空！",
					minlength : "字符长度不能少于2个字符",
					maxlength : "字符长度不能多于50个字符"
				},
                Content : {
                    required : "此项不能为空！",
                    minlength : "字符长度不能少于2个字符",
                    maxlength : "字符长度不能多于2000个字符"
                }
			}
		});
	});
</script>
<%@ include file="../template/admin-tailer.jsp"%>