
	function showPopover(element) {
		var p = $("#" + element);
		var position = p.position();
		$("[id^='group-popover-button']").hide();
		$("#group-" + element).css({
			"display" : "block",
			"top" : (position.top - 40),
			"left" : position.left + 25
		});
	}

	function hidePopover(element) {
		$('#' + element).parents("[id^='group-popover-button']").hide();
	}
