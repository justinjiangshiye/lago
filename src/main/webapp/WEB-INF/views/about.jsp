<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="template/header.jsp"%>

<div class="row row-offcanvas row-offcanvas-right">
	<div class="col-xs-10">
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li class="active"><a href="#aboutUs" role="tab"
				data-toggle="tab">关于我们</a></li>
			<li><a href="#lagoSpirit" role="tab" data-toggle="tab">拉钩精神</a></li>
			<li><a href="#userGuide" role="tab" data-toggle="tab">用户指南</a></li>
			<li><a href="#contactUs" role="tab" data-toggle="tab">联系我们</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane active" id="aboutUs"></div>
			<div class="tab-pane" id="lagoSpirit"></div>
			<div class="tab-pane" id="userGuide"></div>
			<div class="tab-pane" id="contactUs"></div>
		</div>

		<script type="text/javascript">
			$("#aboutUs").load("<c:url value="/staticPage/aboutus" />");
			$("#lagoSpirit").load("<c:url value="/staticPage/lagospirit" />");
			$("#userGuide").load("<c:url value="/staticPage/userguide" />");
			$("#contactUs").load("<c:url value="/staticPage/contactus" />");
		</script>
	</div>
	<%@ include file="template/right.jsp"%>
</div>
<%@ include file="template/tailer.jsp"%>