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

    // Pour tous les liens commençant par #
    // cf. : http://blog.haeresis.fr/la-navigation-interne-dans-une-page-web/
	$("a[href^='#']").click(function (e) {
		// On annule le comportement initial au cas ou la base soit différente de la page courante
		e.preventDefault(); 
				
		// On ajoute le hash dans l'URL
		window.location.hash = $(this).attr("href");
		
		// Une fois en place on va forcer l'affichage N pixels plus haut
		$(window).scrollTop( $(window).scrollTop() - 50 );
	});
});