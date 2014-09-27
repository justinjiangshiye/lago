<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<ul>
	<li><span>分享到：</span></li>
	<li><a href="javascript:void(0)" onclick="shareToSNS('sinaweibo');return false;"><img
			src="<c:url value="/images/share2weibo.gif" />" />新浪微博</a></li>
	<li><a href="javascript:void(0)"
		onclick="shareToSNS('qqspace');return false;"><img
			src="<c:url value="/images/share2qqspace.gif" />" />QQ空间</a></li>
	<li><a href="javascript:void(0)"
		onclick="shareToSNS('txweibo');return false;"><img
			src="<c:url value="/images/share2qqweibo.gif" />" />腾讯微博</a></li>
	<li><a href="javascript:void(0)"
		onclick="shareToWeixin();return false;"><img
			src="<c:url value="/images/share2weixin.gif" />" />微信</a></li>
</ul>
<script type="text/javascript">
	function shareToSNS(sns) {
		window.open("<c:url value="/share/" />" + sns + "/${article.slugsurl}",
				'',
				'width=700, height=680, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, location=yes, resizable=no, status=no');
	}
    function shareToWeixin() {
        window.open("<c:url value="/share/weixin/" />" + "${article.slugsurl}",
                '',
                'width=500, height=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, location=yes, resizable=no, status=no');
    }
</script>