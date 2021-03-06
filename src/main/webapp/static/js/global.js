// override jquery validate plugin defaults
$.validator.setDefaults({
    highlight: function(element) {
        $(element).closest('.form-group').addClass('has-error');
    },
    unhighlight: function(element) {
        $(element).closest('.form-group').removeClass('has-error');
    },
    errorElement: 'span',
    errorClass: 'help-block',
    errorPlacement: function(error, element) {
        if(element.parent('.input-group').length) {
            error.insertAfter(element.parent());
        } else {
            error.insertAfter(element);
        }
    }
});
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
	$('.carousel').carousel({
		interval : 3000
	});
	setInterval('marqueeScrollUp(".marquee")', 3000);
	$(".reply_link").click(function() {
		var id = $(this).attr("data");
		$("#" + id).removeClass("hide").addClass("show");
	});
});