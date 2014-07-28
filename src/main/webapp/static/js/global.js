(function ($) {
    $.extend({
        dynamicForm: function (action) {
            return $('<form name="DynamicForm" method="post" />').attr("action", action).appendTo("body");
        }
    });

    $.fn.extend({
        addHidden: function (name, value) {
            return $(this).append('<input type="hidden" name="' + name + '" value="' + value + '" />');
        }
    });

    /**
    * 限制输入框只能输入数字(JQuery插件)
    * 
    * @author Johnson
    *
    * @example $("#amount").numeral()
    *
    * @example $("#amount").numeral(4) or $("#amount").numeral({'scale': 4})
    *
    * @example $(".x-amount").numeral()
    **/
    $.fn.numeral = function () {
        var args = arguments;
        var json = typeof (args[0]) == "object";
        var scale = json ? args[0].scale : args[0];
        scale = scale || 0;
        $(this).css("ime-mode", "disabled");
        var keys = new Array(8, 9, 35, 36, 37, 38, 39, 40, 46);
        this.bind("keydown", function (e) {
            e = window.event || e;
            var code = e.which || e.keyCode;
            if (e.shiftKey) {
                return false;
            }
            var idx = Array.indexOf(keys, code);
            if (idx != -1) {
                return true;
            }
            var value = this.value;
            if (code == 190 || code == 110) {
                if (scale == 0 || value.indexOf(".") != -1) {
                    return false;
                }
                return true;

            } else {
                if ((code >= 48 && code <= 57) || (code >= 96 && code <= 105)) {
                    if (scale > 0 && value.indexOf(".") != -1) {
                        var reg = new RegExp("^[0-9]+(\.[0-9]{0," + scale + "})?$");
                        var selText = getSelection();
                        if (selText != value && !reg.test(value)) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
        });
        this.bind("blur", function () {
            if (this.value.lastIndexOf(".") == (this.value.length - 1)) {
                this.value = this.value.substr(0, this.value.length - 1);
            } else if (isNaN(this.value)) {
                this.value = "";
            } else {
                var value = this.value;
                if (scale > 0 && value.indexOf(".") != -1) {
                    var reg = new RegExp("^[0-9]+(\.[0-9]{0," + scale + "})?$");
                    if (!reg.test(value)) {
                        this.value = format(value, scale);
                    }
                }
            }
        });
        this.bind("paste", function () {
            var s = window.clipboardData.getData('text');
            if (!/\D/.test(s));
            value = s.replace(/^0*/, '');
            return false;
        });
        this.bind("dragenter", function () {
            return false;
        });
        var format = function (value, scale) {
            return Math.floor(value * Math.pow(10, scale)) / Math.pow(10, scale);
        }
        var getSelection = function () {
            if (window.getSelection) {
                return window.getSelection();
            }
            if (document.selection) {
                return document.selection.createRange().text;
            }
            return "";
        };
        Array.indexOf = function (array, value) {
            for (var i = 0; i < array.length; i++) {
                if (value == array[i]) {
                    return i;
                }
            }
            return -1;
        }
    };

    $.fn.decimal = function () {
        $(this).css("ime-mode", "disabled");
        this.bind("keypress", function (e) {
            var code = (e.keyCode ? e.keyCode : e.which);
            if (!$.browser.msie && (e.keyCode == 0x8)) {
                return;
            }
            return code >= 48 && code <= 57;
        });
        this.bind("blur", function () {
            if (this.value.lastIndexOf(".") == (this.value.length - 1)) {
                this.value = this.value.substr(0, this.value.length - 1);
            } else if (isNaN(this.value)) {
                this.value = "";
            }
        });
        this.bind("paste", function () {
            var s = clipboardData.getData('text');
            if (!/\D/.test(s));
            value = s.replace(/^0*/, '');
            return false;
        });
        this.bind("dragenter", function () {
            return false;
        });
        this.bind("keyup", function () {
            if (/(^0+)/.test(this.value)) {
                this.value = this.value.replace(/^0*/, '');
            }
        });
    };

    $.fn.maxlength = function (settings) {
        if (typeof settings == 'string') {
            settings = { feedback: settings };
        }

        settings = $.extend({}, $.fn.maxlength.defaults, settings);

        function length(el) {
            var parts = el.value;
            if (settings.words)
                parts = el.value.length ? parts.split(/\s+/) : { length: 0 };
            return parts.length;
        }

        return this.each(function () {
            var field = this,
	        	$field = $(field),
	        	$form = $(field.form),
	        	limit = settings.useInput ? $form.find('input[name=maxlength]').val() : $field.attr('maxlength'),
	        	$charsLeft = $form.find(settings.feedback);

            function limitCheck(event) {
                var len = length(this),
	        	    exceeded = len >= limit,
	        		code = event.keyCode;

                if (!exceeded)
                    return;

                switch (code) {
                    case 8:  // allow delete
                    case 9:
                    case 17:
                    case 36: // and cursor keys
                    case 35:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 46:
                    case 65:
                        return;

                    default:
                        return settings.words && code != 32 && code != 13 && len == limit;
                }
            }


            var updateCount = function () {
                var len = length(field),
	            	diff = limit - len;

                $charsLeft.html(diff || "0");

                // truncation code
                if (settings.hardLimit && diff < 0) {
                    field.value = settings.words ?
                    // split by white space, capturing it in the result, then glue them back
	            		field.value.split(/(\s+)/, (limit * 2) - 1).join('') :
	            		field.value.substr(0, limit);

                    updateCount();
                }
            };

            $field.keyup(updateCount).change(updateCount);
            if (settings.hardLimit) {
                $field.keydown(limitCheck);
            }

            updateCount();
        });
    };

    $.fn.maxlength.defaults = {
        useInput: false,
        hardLimit: true,
        feedback: '.charsLeft',
        words: false
    };

    $.fn.disableSelection = function () {
        return this.each(function () {
            $(this).attr('unselectable', 'on')
               .css({
                   '-moz-user-select': 'none',
                   '-webkit-user-select': 'none',
                   'user-select': 'none',
                   '-ms-user-select': 'none'
               })
               .each(function () {
                   this.onselectstart = function () { return false; };
               });
        });
    };
})(jQuery);

$(function(){
	$("#btnSearch").click(function(){
		$.dynamicForm($(this).attr("action")+$("#inputSearch").val())
			.attr("method", "get")
			.submit();
	});
	$('.carousel').carousel({
		interval : 3000
	});
	$('.marquee').marquee();
});