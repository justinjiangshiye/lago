<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</div>
<!-- footer -->
<div class="footer">
	<div class="container">
		<div class="left">
            <span>友情链接：</span>
			<ul class="friendlinks">
				<c:forEach items="${friendLinkList}" var="friendLink" varStatus="status">
					<li><a href="${friendLink.websiteurl}" target="_blank">${friendLink.websitename}</a><c:if test="${status.last==false}"><span>|</span></c:if></li>
				</c:forEach>
			</ul>
		</div>
		<p>云顶畅游&nbsp;版权所有</p>
		<p>Beijing Yunding Changyou Technology CO.,Ltd Copyright©2013 ALL
			Rights reserved</p>
		<p>京ICP备13033577号 京公网安备11010802011887号</p>
	</div>
</div>
</div>
<!-- /container -->
<script type="text/javascript">
    $(function(){
    	$.get("<c:url value="/visit" />?uri=" + encodeURIComponent(window.location.href), function(){});
    });
</script>
</body>
</html>