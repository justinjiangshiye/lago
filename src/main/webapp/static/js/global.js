function marqueeScrollUp(obj) {
	$(obj).find("ul:first").animate({
		marginTop : "-25px"
	}, 500, function() {
		$(this).css({
			marginTop : "0px"
		}).find("li:first").appendTo(this);
	});
}
$(function() {
	$("#btnSearch").click(
			function() {
				$.dynamicForm($(this).attr("action")).addHidden("text",
						$("#inputSearch").val()).submit();
			});
	$('.carousel').carousel({
		interval : 3000
	});
	setInterval('marqueeScrollUp(".marquee")', 3000);
	$(".reply_link").click(function() {
		var id = $(this).attr("data");
		$("#" + id).removeClass("hide").addClass("show");
	});
});