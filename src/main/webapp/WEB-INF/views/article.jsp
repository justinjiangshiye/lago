<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="template/header.jsp"%>
<div class="row row-offcanvas row-offcanvas-right">
	<div class="col-xs-10">
		<h3 class="article-title">${article.title}</h3>
		<div>
			<span><fmt:formatDate value="${article.publishdate}"
					type="date" pattern="yyyy-MM-dd" /></span> <span>${article.category}</span>
			<span>评论&nbsp;TODO</span>
		</div>
		<div>${article.content}</div>
		<div class="article-share">
			<ul>
				<li><span>分享到：</span></li>
				<li><a href="#"><img
						src="<c:url value="/images/share2weibo.gif" />" />新浪微博</a></li>
				<li><a href="#"><img
						src="<c:url value="/images/share2qqspace.gif" />" />QQ空间</a></li>
				<li><a href="#"><img
						src="<c:url value="/images/share2qqweibo.gif" />" />QQ微博</a></li>
				<li><a href="#"><img
						src="<c:url value="/images/share2weixin.gif" />" />微信</a></li>
			</ul>
		</div>
		<!-- 评论 -->
		<div>
			<form action="<c:url value="/commentSave" />" method="post"
				role="form">
				<div class="form-group">
					<c:if test="${currentUser!=null}">
						<input type="hidden" name="userid" value="${currentUser.id}" />
						<input type="hidden" name="nickname" value="${currentUser.nickname}" />
						<input type="hidden" name="profilephotourl" value="${currentUser.profilephotourl}" />
						<img src="${currentUser.profilephotourl}" width="32px" height="32px" />
						<span>${currentUser.nickname}</span>
					</c:if>
					<c:if test="${currentUser==null}">
						<label for="inputNickName">昵称</label>
						<input type="text" class="form-control" id="inputNickName"
							name="nickname" placeholder="请输入昵称">
						<input type="hidden" name="userid" value="" />
					</c:if>
					<input type="hidden" name="articleid" value="${article.id}" />
				</div>
				<div class="form-group">
					<label for="inputComments">评论</label>
					<textarea class="form-control" rows="3" id="inputComments"
						name="content"></textarea>
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
		<div>
			<c:if test="${hasComments==true}">
				<ul>
					<c:forEach items="${commentList}" var="comment">
						<li>
							<div class="col-xs-1">
								<img src="<c:url value="${comment.profilephotourl}" width="32px" height="32px" />" />
							</div>
							<div class="col-xs-11">
								<div class="row">
									${comment.nickname}<span><fmt:formatDate
											value="${comment.createdon}" type="date" pattern="yyyy-MM-dd" /></span>
								</div>
								<div class="row">${comment.content}</div>
								<div class="row">
									<a class="reply_link" data="reply_comment_${comment.id}"
										href="javascript:void(0);">回复</a>
								</div>
								<div id="reply_comment_${comment.id}" class="row hide">
									<form action="<c:url value="/replyToCommentSave" />"
										method="post" role="form">
										<div class="form-group">
											<c:if test="${currentUser!=null}">
												<input type="hidden" name="userid" value="${currentUser.id}" />
												<input type="hidden" name="nickname" value="${currentUser.nickname}" />
												<input type="hidden" name="profilephotourl" value="${currentUser.profilephotourl}" />
												<img src="${currentUser.profilephotourl}" width="32px" height="32px" />
												<span>${currentUser.nickname}</span>
											</c:if>
											<c:if test="${currentUser==null}">
												<label for="inputNickName">昵称</label>
												<input type="text" class="form-control" id="inputNickName"
													name="nickname" placeholder="请输入昵称">
												<input type="hidden" name="userid" value="" />
											</c:if>
											<input type="hidden" name="commentid" value="${comment.id}" />
											<input type="hidden" name="articleid" value="${article.id}" />
										</div>
										<div class="form-group">
											<label for="inputComments">评论</label>
											<textarea class="form-control" rows="3" id="inputComments"
												name="content"></textarea>
										</div>
										<button type="submit" class="btn btn-default">Submit</button>
									</form>
								</div>
								<c:if test="${comment.replyToCommentList.size() > 0}">
									<div class="row">
										<ul>
											<c:forEach items="${comment.replyToCommentList}" var="reply">
												<li>
													<div class="col-xs-1">
														<img
															src="<c:url value="${reply.profilephotourl}" width="32px" height="32px" />" />
													</div>
													<div class="col-xs-11">
														<div class="row">
															${reply.nickname}<span><fmt:formatDate
																	value="${reply.createdon}" type="date"
																	pattern="yyyy-MM-dd" /></span>
														</div>
														<div class="row">${reply.content}</div>
													</div>
												</li>
											</c:forEach>
										</ul>
									</div>
								</c:if>
							</div>
						</li>
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${hasComments==false}">
		        暂无任何评论！
		    </c:if>
		</div>
	</div>
	<%@ include file="template/right.jsp"%>
</div>
<%@ include file="template/tailer.jsp"%>