<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="template/header.jsp"%>
<div class="row">
	<div class="col-xs-9">
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
					<img alt="" src="<c:url value="/files/casoul1.png" />">
					<div class="carousel-caption">
						<h5>即使杀光所有报晓的公鸡，天，还是会亮的</h5>
					</div>
				</div>
				<div class="item">
					<img alt="" src="<c:url value="/files/casoul1.png" />">
					<div class="carousel-caption">
						<h5>即使杀光所有报晓天，还是会亮的</h5>
					</div>
				</div>
				<div class="item">
					<img alt="" src="<c:url value="/files/casoul1.png" />">
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
			<div class="col-xs-6 home-article">
				<div class="article-splitter">父母学堂</div>
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
                                <li class="list-group-item"><a href="<c:url value="/article/${item.slugsurl}" />" >${item.title}
                                    <span class="navbar-right"><fmt:formatDate value="${item.publishdate}" type="date" pattern="yyyy-MM-dd"  /></span>
                                </a></li>
                            </c:if>
                        </c:forEach>
					</ul>
				</div>
			</div>
			<div class="col-xs-6 home-article">
				<div class="article-splitter">守护成长</div>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <c:forEach items="${growupList}" var="item"
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
                        <c:forEach items="${growupList}" var="item"
                            varStatus="itemStatus">
                            <c:if test="${itemStatus.first==false}">
                                <li class="list-group-item"><a href="<c:url value="/article/${item.slugsurl}" />" >${item.title}
                                <span class="navbar-right"><fmt:formatDate value="${item.publishdate}" type="date" pattern="yyyy-MM-dd"  /></span></a></li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-6  home-article">
				<div class="article-splitter">我爱我家</div>
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
                                <li class="list-group-item"><a href="<c:url value="/article/${item.slugsurl}" />" >${item.title}
                                <span class="navbar-right"><fmt:formatDate value="${item.publishdate}" type="date" pattern="yyyy-MM-dd"  /></span></a></li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </div>
			</div>
			<div class="col-xs-6 home-article">
				<div class="article-splitter">亲子阅读</div>
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
                                <li class="list-group-item"><a href="<c:url value="/article/${item.slugsurl}" />" >${item.title}
                                <span class="navbar-right"><fmt:formatDate value="${item.publishdate}" type="date" pattern="yyyy-MM-dd"  /></span></a></li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </div>
			</div>
		</div>
	</div>
	<%@ include file="template/right.jsp"%>
</div>
<%@ include file="template/tailer.jsp"%>