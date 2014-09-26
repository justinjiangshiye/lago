<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- JiaThis Button BEGIN -->
<ul>
    <li><span>分享到：</span></li>
    <li><a class="jiathis_button_tsina"><img
            src="<c:url value="/images/share2weibo.gif" />" />新浪微薄</a></li>
    <li><a class="jiathis_button_qzone"><img
            src="<c:url value="/images/share2qqspace.gif" />" />QQ空间</a></li>
    <li><a class="jiathis_button_tqq"><img
            src="<c:url value="/images/share2qqweibo.gif" />" />腾讯微薄</a></li>
    <li><a class="jiathis_button_weixin"><img
            src="<c:url value="/images/share2weixin.gif" />" />微信</a></li>
</ul>
<script type="text/javascript">
var jiathis_config={
    data_track_clickback:true,
    summary:'${article.abstractcontent}'
}
</script>
<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js?uid=1970024" charset="utf-8"></script>
<!-- JiaThis Button END -->

<%
/*
<ul>
	<li><span>分享到：</span></li>
	<li><a href="javascript:void(0)"
		onclick="shareSinaWeibo();return false;"><img
			src="<c:url value="/images/share2weibo.gif" />" />新浪微博</a></li>
	<li><a href="javascript:void(0)"
		onclick="shareQQSpace();return false;"><img
			src="<c:url value="/images/share2qqspace.gif" />" />QQ空间</a></li>
	<li><a href="javascript:void(0)"
		onclick="shareQQWeibo();return false;"><img
			src="<c:url value="/images/share2qqweibo.gif" />" />腾讯微博</a></li>
	<li><a href="javascript:void(0)" class="jiathis_button_weixin"><img
			src="<c:url value="/images/share2weixin.gif" />" />微信</a></li>
</ul>
<!-- JiaThis Button BEGIN -->
<script type="text/javascript"
	src="http://v3.jiathis.com/code/jia.js?uid=1" charset="utf-8"></script>
<!-- JiaThis Button END -->
<script type="text/javascript">
	function shareSinaWeibo() {
		var p = {
			url : location.href,
			type : 'buttn',
			language : 'zh_cn',
			appkey : '356903098',
			title : '【${article.title}】' + '${article.abstractcontent}'
		};
		var s = [];
		for ( var i in p) {
			s.push(i + '=' + encodeURIComponent(p[i] || ''));
		}
		var _u = 'http://service.weibo.com/share/share.php?' + s.join('&');
		window
				.open(
						_u,
						'',
						'width=700, height=680, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, location=yes, resizable=no, status=no');
	}

	function shareQQSpace() {
		var p = {
			url : location.href,
			title : '${article.title}',
			site : '51拉钩',
			pics : [ "${article.bannerurl}" ].join("|"),
			summary : '${article.abstractcontent}'
		};
		var s = [];
		for ( var i in p) {
			s.push(i + '=' + encodeURIComponent(p[i] || ''));
		}
		var _u = 'http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?'
				+ s.join('&');
		window
				.open(
						_u,
						'',
						'width=700, height=680, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, location=yes, resizable=no, status=no');
	}
	function shareQQWeibo() {
		var _url = encodeURIComponent(document.location);
		var _assname = encodeURI("");//你注册的帐号，不是昵称
		var _appkey = encodeURI("801537802");//你从腾讯获得的appkey
		var _pic = encodeURI('${article.bannerurl}');//（例如：var _pic='图片url1|图片url2|图片url3....）
		var _t = '${article.abstractcontent}';//标题和描述信息
		_t = '【${article.title}】' + _t;//请在这里添加你自定义的分享内容
		if (_t.length > 120) {
			_t = _t.substr(0, 117) + '...';
		}
		_t = encodeURI(_t);

		var _u = 'http://share.v.t.qq.com/index.php?c=share&a=index&url='
				+ _url + '&appkey=' + _appkey + '&pic=' + _pic + '&assname='
				+ _assname + '&title=' + _t;
		window
				.open(
						_u,
						'',
						'width=700, height=680, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, location=yes, resizable=no, status=no');
	}
</script>
*/ %>