<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">新增管理员</h3>
<form class="form-horizontal" role="form" method="post"
	action="<c:url value="/admin/userSave"/>">
	<div class="form-group">
		<label for="inputLoginid" class="col-sm-2 control-label">登录名</label>
		<div class="col-sm-10">
			<input id="inputLoginid" name="Loginid" type="text" class="form-control">
		</div>
	</div>
    <div class="form-group">
        <label for="inputNickname" class="col-sm-2 control-label">昵称</label>
        <div class="col-sm-10">
            <input id="inputNickname" name="Nickname" type="text" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input id="inputPassword" name="Password" type="password" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPasswordConfirm" class="col-sm-2 control-label">密码确认</label>
        <div class="col-sm-10">
            <input id="inputPasswordConfirm" name="PasswordConfirm" type="password" class="form-control">
        </div>
    </div>
	<div class="form-group">
		<label for="inputProfilephotourl" class="col-sm-2 control-label">头像</label>
		<div class="col-sm-10">
			<input id="inputProfilephotourl" name="Profilephotourl" type="hidden" value="/images/default-user-photo.gif"
				class="form-control">
			<img id="imgProfilephotourl" src="<c:url value="/images/default-user-photo.gif" />" width="32px" height="32px" /><br />
			<iframe src="<c:url value="/admin/uploadFile" />" frameborder="0" scrolling="no" width="700px" height="40px"></iframe>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">保存</button>
		</div>
	</div>
</form>
<script type="text/javascript">
    function fileUploaded(url) {
    	$("#inputProfilephotourl").val(url);
    	$("#imgProfilephotourl").attr("src", url);
    }
</script>
<%@ include file="../template/admin-tailer.jsp"%>