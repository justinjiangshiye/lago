<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<ul>
	<li><span>分享到：</span></li>
	<li><a href="#"><img
			src="<c:url value="/images/share2weibo.gif" />" />新浪微博</a></li>
	<li><a href="javascript:void(0)"
		onclick="postQQSpace();return false;"><img
			src="<c:url value="/images/share2qqspace.gif" />" />QQ空间</a></li>
	<li><a href="javascript:void(0)"
		onclick="postToWb();return false;"><img
			src="<c:url value="/images/share2qqweibo.gif" />" />腾讯微博</a></li>
	<li><a href="#"><img
			src="<c:url value="/images/share2weixin.gif" />" />微信</a></li>
</ul>
<script type="text/javascript">
	function postQQSpace() {
		var p = {
			url : location.href,
			showcount : '1',/*是否显示分享总数,显示：'1'，不显示：'0' */
			desc : '这片美文真心很赞，快来看看吧！',/*默认分享理由(可选)*/
			summary : '${article.abstractcontent}',/*分享摘要(可选)*/
			title : '${article.title}',/*分享标题(可选)*/
			site : '51拉钩',/*分享来源 如：腾讯网(可选)*/
			pics : [ encodeURIComponent("${article.bannerurl}") ].join("|"), /*分享图片的路径(可选)*/
			style : '202',
			width : 105,
			height : 31
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
	function postToWb() {
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