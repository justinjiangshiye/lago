<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">编辑友情链接</h3>
<form id="form" class="form-horizontal" role="form" method="post" action="<c:url value="/admin/friendLinkSave"/>">
	<div class="form-group">
        <label for="inputWebsitename" class="col-sm-2 control-label">网站名称</label>
        <div class="col-sm-10">
            <input id="inputWebsitename" name="Websitename" type="text" class="form-control" value="${friendLink.websitename}">
            <input type="hidden" name="Id" value="${friendLink.id}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputWebsiteurl" class="col-sm-2 control-label">网站链接</label>
        <div class="col-sm-10">
            <input id="inputWebsiteurl" name="Websiteurl" type="text" class="form-control" value="${friendLink.websiteurl}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputLogourl" class="col-sm-2 control-label">图标链接</label>
        <div class="col-sm-10">
            <input id="inputLogourl" name="Logourl" type="text" class="form-control" value="${friendLink.logourl}">
        </div>
    </div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
            <a href="<c:url value="/admin/friendLinks" />" class="btn btn-default">返回</a>
            <button type="submit" class="btn btn-primary">保存</button>
		</div>
	</div>
</form>
<script type="text/javascript">
    $(document).ready(function() {
        $('#form').validate({
            rules : {
                Websitename : {
                    required : true
                },
                Websiteurl : {
                    required : true
                }
            },
            messages : {
                Websitename : {
                    required : "此项不能为空！"
                },
                Websiteurl : {
                    required : "此项不能为空！"
                }
            }
        });
    });
</script>
<%@ include file="../template/admin-tailer.jsp"%>