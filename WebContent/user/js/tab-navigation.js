$(document).ready(function() {
	"use strict";
	jQuery(".show-hide-detail").hide();
	jQuery(".show-hide-detail:first").show();
	jQuery(".show-hide-btn a").on('click',function() {
		var thid_data = jQuery(this).attr('data-id');
		jQuery(".show-hide-btn a").removeClass('active');
		jQuery(this).addClass('active');
		if (!jQuery("#" + thid_data).is(":visible")) {
			jQuery(".show-hide-detail").hide();
			jQuery("#" + thid_data).show();
		}
	});
}); 