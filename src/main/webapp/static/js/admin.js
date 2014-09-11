$(function() {
	$(".delete").click(function() {
		var url = $(this).attr("action");
		if (confirm("您确定要删除吗？")) {
			$.dynamicForm(url).submit();
		}
	});
});