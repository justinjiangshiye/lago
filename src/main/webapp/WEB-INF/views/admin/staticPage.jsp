<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../template/admin-header.jsp"%>
<h3 class="sub-header">展示页管理</h3>
<div>
	<a href="<c:url value="/admin/staticPage/51lago" />" type="button"
		class="btn <c:choose><c:when test="${staticPage.category=='51lago'}">btn-primary</c:when><c:otherwise>btn-default</c:otherwise></c:choose> ">51拉钩</a>
	<a href="<c:url value="/admin/staticPage/51tingting" />" type="button"
		class="btn <c:choose><c:when test="${staticPage.category=='51tingting'}">btn-primary</c:when><c:otherwise>btn-default</c:otherwise></c:choose>">51听听</a>
	<a href="<c:url value="/admin/staticPage/aboutus" />" type="button"
		class="btn <c:choose><c:when test="${staticPage.category=='aboutus'}">btn-primary</c:when><c:otherwise>btn-default</c:otherwise></c:choose>">关于我们</a>
	<a href="<c:url value="/admin/staticPage/lagospirit" />" type="button"
		class="btn <c:choose><c:when test="${staticPage.category=='lagospirit'}">btn-primary</c:when><c:otherwise>btn-default</c:otherwise></c:choose>">拉钩精神</a>
	<a href="<c:url value="/admin/staticPage/userguide" />" type="button"
		class="btn <c:choose><c:when test="${staticPage.category=='userguide'}">btn-primary</c:when><c:otherwise>btn-default</c:otherwise></c:choose>">用户指南</a>
	<a href="<c:url value="/admin/staticPage/contactus" />" type="button"
		class="btn <c:choose><c:when test="${staticPage.category=='contactus'}">btn-primary</c:when><c:otherwise>btn-default</c:otherwise></c:choose>">联系我们</a>
    <br />
</div>
<div class="table-responsive">
	<form class="form-horizontal" role="form" method="post"
		action="<c:url value="/admin/staticPageSave"/>">
		<div class="form-group col-sm-12">
			<label for="inputContent" class="control-label">内容</label>
			<div>
				<input type="hidden" name="Category" value="${staticPage.category}" />
				<textarea id="inputContent" name="Content" class="form-control"
					rows="20">${staticPage.content}</textarea>
			</div>
		</div>
		<div class="form-group col-sm-12">
			<div>
				<button type="submit" class="btn btn-default">保存</button>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#inputContent").cleditor({height:500});
	});
</script>
<%@ include file="../template/admin-tailer.jsp"%>