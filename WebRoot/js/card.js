function card(){
	// Setup arrays to hold information for slideshow
	var slideArray = ["photo1.jpg","photo2.jpg","photo3.jpg","photo4.jpg"];
	/*var textArray = ["","刻苦","2","3"];*/
	var urlArray = ["#", "#", "#", "#"];

	// Add the HTML to the DOM
	$('.card').append('<div class="slide-card" />');
	$('.card').after('<ul id="nav" class="clearfix"></ul>');

	// Loop thru the array and add the images to the DOM
	for(var i=0; i < slideArray.length; i++){
	    var slideNum = i + 1;
	    $('#nav').append('<li><a href="#" rel="'+slideNum+'">'+slideNum+'</a></li>');
	    var slideInfo = '<div class="slide-image'+slideNum+' slides">';
	    slideInfo += '<a href="'+urlArray[i]+'">';
	   /* slideInfo += '<div class="slide-text activeInfo'+[i]+'">'+textArray[i]+'</div>';*/
	    slideInfo += '<img src="pic/'+slideArray[i]+'"/></a></div>';
	    $('.slide-card').append(slideInfo);
	}

	// Setup variables
	var slideTotal = 4;
	var slideWidth = 600;   
	var slidecard = slideWidth * slideTotal;

	// Assign width to slide-card
	$(".slide-card").css({'width' : slidecard});

	// Setup click event to make slideshow animate
	$('#nav li a').bind('click', function(){
	    $('#nav li a').removeClass('active');
	    $(this).addClass('active');
	    $(".slide-text").css({
	    'top':'-100px',
	    'right':'0px'
	    });
	    $(".slide-text").stop();
	    $(".slide-text").clearQueue();

	    var active = $('#nav li a.active').attr("rel") - 1; 
	    var slidePos = active * slideWidth; 
	    var slideNum = $('#nav li a.active').attr("rel");

	    $(".slide-card").animate({
	        left: -slidePos
	        },1000, function(){
	            $('.slide-image'+slideNum+' .slide-text').addClass('textStrip').animate({
	                top:0,
	                left:slidePos,
	                right:0
	                }, 1000, function(){
	                $('.slide-text').delay(5000).animate({
	                    top:-100
	                    }, 1000);
	                });
	        });

	    }); 
	}