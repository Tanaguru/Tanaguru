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