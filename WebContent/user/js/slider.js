$(document).ready(function() {
	"use strict";
	var currentImage = "";
	var currentBullet= "";
	var nextimage = 0;
	doSlideshow();
	function doSlideshow() {
		currentImage = $(".active_image");
		$(currentImage).removeClass("active_image");
		if (!$(currentImage).next(".image_header").length) {
			$(".image_header").first().addClass("active_image");
		} else {
			$(currentImage).next(".image_header").addClass("active_image");
		}
		setTimeout(doSlideshow, 5000);
	}

	$(".next_image_btn").on('click',function() {
		moveNextImage();
	});
	$(".previous_image_btn").on('click',function() {
		movePreviousImage();
	});
	function moveNextImage()
	{
		currentImage = $(".active_image");
		currentBullet=$(".slider_bullets .active").removeClass("active");
		$(currentImage).removeClass("active_image");
		if (!$(currentImage).next(".image_header").length) 
		{
			$(".image_header").first().addClass("active_image");
			$(".slider_bullets li").first().addClass("active");
		}
		else 
		{
			$(currentImage).next(".image_header").addClass("active_image");
			$(currentBullet).next().addClass("active");
		}		
	}
	function movePreviousImage()
	{
		currentImage = $(".active_image");
		currentBullet=$(".slider_bullets .active").removeClass("active");		
		$(currentImage).removeClass("active_image");	
		if (!$(currentImage).prev(".image_header").length) 
		{
			$(".image_header").last().addClass("active_image");
			$(".slider_bullets li").last().addClass("active");
		}
		else 
		{
			$(currentImage).prev(".image_header").addClass("active_image");
			$(currentBullet).prev().addClass("active");			
		}		
	}	
}); 