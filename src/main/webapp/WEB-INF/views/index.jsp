<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="template/header.jsp"%>
<div class="row">
	<div class="col-xs-10">
		<!--  Banner图片  -->
		<div id="myCarousel" class="carousel slide">
			<ol class="carousel-indicators">
                <c:forEach items="${bannerlinkList}" var="item"
                    varStatus="itemStatus">
                    <li data-target="#myCarousel" data-slide-to="${itemStatus.index}" <c:if test="${itemStatus.first==true}">class="active"</c:if> ></li>
                </c:forEach>
			</ol>
			<div class="carousel-inner">
				<c:forEach items="${bannerlinkList}" var="item"
					varStatus="itemStatus">
					<div class="<c:if test="${itemStatus.first==true}">active </c:if>item">
						<a target="_blank" href="<c:url value="${item.contenturl}" />"><img alt="" src="<c:url value="${item.bannerurl}" />" width="945px" height="405px"></a>
						<div class="carousel-caption">
							<h5>${item.text}</h5>
						</div>
					</div>
				</c:forEach>
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
			<div class="col-xs-6 home-article">
				<div class="article-splitter">父&nbsp;母&nbsp;学&nbsp;堂</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<c:forEach items="${parentschoolList}" var="item"
							varStatus="itemStatus">
							<c:if test="${itemStatus.first==true}">
								<img src="<c:url value="${item.bannerurl}" />" />
								<p>${item.abstractcontent}</p>
								<a href="<c:url value="/article/${item.slugsurl}" />"
									class="btn success btn-xs">阅读全文</a>
							</c:if>
						</c:forEach>
					</div>
					<ul class="list-group">
						<c:forEach items="${parentschoolList}" var="item"
							varStatus="itemStatus">
							<c:if test="${itemStatus.first==false}">
								<li class="list-group-item"><a
									href="<c:url value="/article/${item.slugsurl}" />">${item.title}
										<span class="navbar-right"><fmt:formatDate
												value="${item.publishdate}" type="date" pattern="yyyy-MM-dd" /></span>
								</a></li>
							</c:if>
						</c:forEach>
					</ul>
					<div><a href="<c:url value="/category/parent-school" />">更多</a></div>
				</div>
			</div>
			<div class="col-xs-6 home-article">
				<div class="article-splitter">守&nbsp;护&nbsp;成&nbsp;长</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<c:forEach items="${growupList}" var="item" varStatus="itemStatus">
							<c:if test="${itemStatus.first==true}">
								<img src="<c:url value="${item.bannerurl}" />" />
								<p>${item.abstractcontent}</p>
								<a href="<c:url value="/article/${item.slugsurl}" />"
									class="btn success btn-xs">阅读全文</a>
							</c:if>
						</c:forEach>
					</div>
					<ul class="list-group">
						<c:forEach items="${growupList}" var="item" varStatus="itemStatus">
							<c:if test="${itemStatus.first==false}">
								<li class="list-group-item"><a
									href="<c:url value="/article/${item.slugsurl}" />">${item.title}
										<span class="navbar-right"><fmt:formatDate
												value="${item.publishdate}" type="date" pattern="yyyy-MM-dd" /></span>
								</a></li>
							</c:if>
						</c:forEach>
					</ul>
					<div><a href="<c:url value="/category/grow-up" />">更多</a></div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-6  home-article">
				<div class="article-splitter">我&nbsp;爱&nbsp;我&nbsp;家</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<c:forEach items="${lovefamilyList}" var="item"
							varStatus="itemStatus">
							<c:if test="${itemStatus.first==true}">
								<img src="<c:url value="${item.bannerurl}" />" />
								<p>${item.abstractcontent}</p>
								<a href="<c:url value="/article/${item.slugsurl}" />"
									class="btn success btn-xs">阅读全文</a>
							</c:if>
						</c:forEach>
					</div>
					<ul class="list-group">
						<c:forEach items="${lovefamilyList}" var="item"
							varStatus="itemStatus">
							<c:if test="${itemStatus.first==false}">
								<li class="list-group-item"><a
									href="<c:url value="/article/${item.slugsurl}" />">${item.title}
										<span class="navbar-right"><fmt:formatDate
												value="${item.publishdate}" type="date" pattern="yyyy-MM-dd" /></span>
								</a></li>
							</c:if>
						</c:forEach>
					</ul>
					<div><a href="<c:url value="/category/love-family" />">更多</a></div>
				</div>
			</div>
			<div class="col-xs-6 home-article">
				<div class="article-splitter">亲&nbsp;子&nbsp;阅&nbsp;读</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<c:forEach items="${readingList}" var="item"
							varStatus="itemStatus">
							<c:if test="${itemStatus.first==true}">
								<img src="<c:url value="${item.bannerurl}" />" />
								<p>${item.abstractcontent}</p>
								<a href="<c:url value="/article/${item.slugsurl}" />"
									class="btn success btn-xs">阅读全文</a>
							</c:if>
						</c:forEach>
					</div>
					<ul class="list-group">
						<c:forEach items="${readingList}" var="item"
							varStatus="itemStatus">
							<c:if test="${itemStatus.first==false}">
								<li class="list-group-item"><a
									href="<c:url value="/article/${item.slugsurl}" />">${item.title}
										<span class="navbar-right"><fmt:formatDate
												value="${item.publishdate}" type="date" pattern="yyyy-MM-dd" /></span>
								</a></li>
							</c:if>
						</c:forEach>
					</ul>
					<div><a href="<c:url value="/category/reading" />">更多</a></div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="template/right.jsp"%>
</div>
<%@ include file="template/tailer.jsp"%>