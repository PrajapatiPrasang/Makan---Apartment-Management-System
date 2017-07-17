$(document).ready(function(){
	"use strict";
	$("form[name='contact_form']").on('submit',function() {
	    var url = "functions.php"; // the script where you handle the form input.
	    var thisForm = $(this);
	    var btnValue=$(this).find(".send-message").attr('value');
	    $(this).find(".send-message").attr('value', 'SUBMITTING...');
	    $(this).find(".send-message").attr('disabled', 'disabled');
	    $.ajax({
	           type: "POST",
	           url: url,
	           data: thisForm.serialize(), // serializes the form's elements.
	           success: function(data)
	           {
	               // show response from the php script.
	               $('#contact_our_agent').modal('hide');
	               $(".alert-message").html(data);	               
	               $(".alert-container").show();
	               thisForm.trigger("reset");
	               thisForm.find(".send-message").attr('value', btnValue);
	               thisForm.find(".send-message").removeAttr('disabled');
	           }
	         });
	
	    return false; // avoid to execute the actual submit of the form.
	});
	
	$(".alert .close").on('click',function(){
		$(".alert-container").hide();
	});
});
