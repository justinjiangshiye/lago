<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="template/header.jsp"%>
<div class="row">
	<div class="col-xs-10">
		<!--  Banner图片  -->
		<div id="myCarousel" class="carousel slide">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!-- Carousel items -->
			<div class="carousel-inner">
				<div class="active item">
					<img alt="" src="<c:url value="/file/casoul1.png" />">
					<div class="carousel-caption">
						<h5>即使杀光所有报晓的公鸡，天，还是会亮的</h5>
					</div>
				</div>
				<div class="item">
					<img alt="" src="<c:url value="/file/casoul1.png" />">
					<div class="carousel-caption">
						<h5>即使杀光所有报晓天，还是会亮的</h5>
					</div>
				</div>
				<div class="item">
					<img alt="" src="<c:url value="/file/casoul1.png" />">
					<div class="carousel-caption">
						<h5>即使杀光所有鸡，天，还是会亮的</h5>
					</div>
				</div>
			</div>
			<!-- Controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>

		<!--  文章列表  -->
		<div class="row">
			<div class="col-xs-6">
				<div class="article-splitter">父母学堂</div>
				<div class="panel panel-default">
				  <!-- Default panel contents -->
				  <div class="panel-body">
				    <img src="" />
				    <p></p>
				  </div>
				
				  <!-- List group -->
				  <ul class="list-group">
				    <li class="list-group-item">Cras justo odio</li>
				    <li class="list-group-item">Dapibus ac facilisis in</li>
				    <li class="list-group-item">Morbi leo risus</li>
				    <li class="list-group-item">Porta ac consectetur ac</li>
				    <li class="list-group-item">Vestibulum at eros</li>
				  </ul>
				</div>
			</div>
			<div class="col-xs-6">
				<div class="article-splitter">守护成长</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-6">
				<div class="article-splitter">我爱我家</div>
			</div>
			<div class="col-xs-6">
				<div class="article-splitter">亲子阅读</div>
			</div>
		</div>
	</div>
	<%@ include file="template/right.jsp"%>
</div>
<%@ include file="template/tailer.jsp"%>