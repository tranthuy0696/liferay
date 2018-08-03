	
	function openSidebar(){
     $('.menu').toggleClass('active');
    $('.main').toggleClass('active');
   
	}
	function openNotify(){
		$('.notify').slideToggle(500);
	}
	$(document).on('click', function(e) {
    if (!e.target.hasClass('notify')) {
      $('.notify').hide(700);
    }
});
