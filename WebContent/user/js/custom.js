jQuery(document).ready(function(){
	"use strict";
	jQuery(".property-type li a").on('click',function(){
		var property_type = jQuery(this).attr('data-id');
		jQuery(".property-type li a").removeClass("active");
		jQuery(this).addClass("active");
		jQuery(".carousel.slide.carousel-slide-recent-property").css('display','none');
		jQuery("div[data-target="+property_type+"]").css('display','block');

		if( property_type == 'All'){
			jQuery(".carousel.slide.carousel-slide-recent-property").css('display','block');
		}

		if( property_type == 'All'){
			jQuery(".property-list-list").css('display','block');
			jQuery(".carousel-slide-recent-property").css('display','block');
		} else {
			jQuery(".property-list-list").css('display','none');
			jQuery(".carousel-slide-recent-property").css('display','none');
			jQuery("div[data-target="+property_type+"]").css('display','block');
		}		
	});
});