$(window).scroll(function() {
    var position = $(this).scrollTop();
    $('.thematique').each(function() {
        var target = $(this).offset().top;
        var id = $(this).attr('id');
        
        if (position >= target) {
            $('#navtoc > nav > ul > li').removeClass('on');
            $('#navtoc > nav > ul > li > a[href=#' + id + ']').parent().addClass('on');
        }
    });
});

$( document ).ready(function() {
	$toto=false;
    $("#btnnav").on('click',function(){
    	if ($toto){
    		$('#nav').hide();
    		$toto=false;
    		$("#btnnav").attr('aria-expanded','false');
    	} else {
    		$('#nav').show();
    		$toto=true;
    		$("#btnnav").attr('aria-expanded','true');
    	}
    });
});